package com.example.music_app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.auth.HttpBearerAuth;
import com.alibaba.xingchen.model.CharacterKey;
import com.alibaba.xingchen.model.ChatReqParams;
import com.alibaba.xingchen.model.ModelParameters;
import com.alibaba.xingchen.model.ResultDTOChatResult;
import com.alibaba.xingchen.model.UserProfile;
import com.alibaba.xingchen.model.ext.chat.ChatContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.music_app.R;
import com.example.music_app.adapter.SingleMessageAdapter;
import com.example.music_app.bean.Constant;
import com.example.music_app.bean.Message;
import com.example.music_app.bean.Variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AiAnswerActivity  extends Activity {
    RecyclerView message_list;
    private List<Message> messageList = new ArrayList<>();
    private SingleMessageAdapter adapter;
    ResultDTOChatResult results = null;
    TextView send;
    EditText content;
    private String prologue = "";  // 序言
    String search;
    TextView title_bar_text;
    RelativeLayout left_img_view;
    private BaseQuickAdapter mAdapter,mAdapter2,mAdaptermain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_answord);
        left_img_view=findViewById(R.id.left_img_view);
        title_bar_text=findViewById(R.id.title_bar_text);
        title_bar_text.setText("AI问答");
        message_list=findViewById(R.id.message_list);
        message_list.setLayoutManager(new GridLayoutManager(AiAnswerActivity.this, 3));
        send=findViewById(R.id.send);
        content=findViewById(R.id.content);
        left_img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initAnswerList();
    }
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    if(adapter.getItemCount()>1){ message_list.smoothScrollToPosition(adapter.getItemCount() - 1);}
                    break;
            }
        }
    };
    public void initAnswerList(){
        init_adapter();
        init_control();
    }
    private void init_adapter() {
        prologue = prologue.replaceAll("\n","");
        boolean showPrologue = prologue.equals("")? false:true;
        adapter = new SingleMessageAdapter(AiAnswerActivity.this,messageList,prologue,showPrologue);
        message_list.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AiAnswerActivity.this,LinearLayoutManager.VERTICAL,false);
//        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);  // 让 recyclerview 跟随键盘弹起
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AiAnswerActivity.this,1);
        message_list.setLayoutManager(gridLayoutManager);
    }
    private void init_control() {

        // 发送
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( content.getText().toString().isEmpty()) {return;}

                Log.d("chat","发送消息");
                String contents =  content.getText().toString();
                search=contents;
                // 添加数据库
                Message message = new Message();
                message.content = contents;
                message.role = Constant.GPT_USER;
                message.type = Constant.MESSAGE_QUESTION;
                message.createTime = System.currentTimeMillis();
                Variable.lastestSend = message;
                init_message(message);
                // 刷新列表
                sendWindowMessage();
                content.setText("");  // 清空输入栏
            }
        });
        // 解决键盘弹起时遮挡 recyclerview 问题
        content.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.d("chat","请求焦点："+b);
                if(b){
//                    application.showKeyboard(viewBinding.content);
                    handler.sendEmptyMessageDelayed(0,250);
                }
            }
        });
    }

    private void init_message(  Message message) {
        // 获取消息列表
        messageList.add(message);
        // Collections.reverse(messageList); // 反转术式
        Log.d("chat","消息数量："+messageList.size());
        adapter.update(messageList);
        // 滚动到底部
        handler.sendEmptyMessage(0);

    }

    public void sendWindowMessage(){
        ChatApiSub api = new ChatApiSub();

        ApiClient apiClient = new ApiClient();

        apiClient.setBasePath("https://nlp.aliyuncs.com");

        apiClient.addDefaultHeader("X-DashScope-SSE", "disable");

        HttpBearerAuth authorization = (HttpBearerAuth) apiClient.getAuthentication("Authorization");

        authorization.setBearerToken("lm-P61tCakp2gfs1L+PaMymvg==");

        api.setApiClient(apiClient);

        new Thread(new Runnable(){
            @Override
            public void run() {
                //请求详情
                try {
                    results = api.chat(buildChatReqParams());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // 在这里更新你的View
                            Message messages = new Message();
                            messages.content = JSONObject.toJSONString(results.getData().getChoices().get(0).getMessages().get(0).getContent());
                            messages.role = Constant.GPT_ASSISTANT;
                            messages.type = Constant.MESSAGE_SUCCESS;
                            messages.status=Constant.MESSAGE_SUCCESS;
                            messages.createTime = System.currentTimeMillis();
                            Variable.lastestSend = messages;
                            init_message(messages);
                            String answer=JSONObject.toJSONString(results.getData().getChoices().get(0).getMessages().get(0).getContent());

                        }
                    });

                } catch (ApiException e) {

                    e.printStackTrace();
                }

            }}).start();
    }
    private ChatReqParams buildChatReqParams() {

        return ChatReqParams.builder()

                .botProfile(

                        CharacterKey.builder()

                                // 星尘预制角色

                                .characterId("0280189272884cfaa3e4054877349cb9")

                                .name("小明")

                                .build()

                )

                .modelParameters(

                        ModelParameters.builder()

                                .seed(1683806810L)
                                .incrementalOutput(false)
                                .build()

                )

                .userProfile(

                        UserProfile.builder()

                                .userId("1630260986617629")

                                .build()

                )

                .messages(

                        Arrays.asList(

                                // 注意，自定义角色 prompt，用户问题需放到messages最后一条

                                com.alibaba.xingchen.model.Message.builder()

                                        .name("小明")

                                        .content(search)

                                        .role("user")

                                        .build()

                        )

                )

                .context(

                        ChatContext.builder()

                                .useChatHistory(true) // 使用平台对话历史，messages 只能包含用户提问消息，不能包含其他信息

                                .build()

                )

                .build();

    }
}
