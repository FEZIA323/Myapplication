package com.example.music_app;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class IndexActivity extends TabActivity {
    private TabHost tabHost;
    private RadioButton rbAnBao,rbYuanCheng;
    private String value="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Intent intent=getIntent();
        value=intent.getStringExtra("value");

        initView();
       // load() ;
    }


    private void initView() {

        rbAnBao=(RadioButton) findViewById(R.id.indexs_activity_jinzhanguanli);
        rbYuanCheng=(RadioButton) findViewById(R.id.indexs_activity_yuanchengfuzhu);

      //  addTab();
    }


//    private void load() {
//        RadioGroup grp = (RadioGroup) this.findViewById(R.id.rGrp);
//        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.indexs_activity_jinzhanguanli:
//
//                        rbAnBao.setTextColor(Color.rgb(102, 102, 102));
//                        rbYuanCheng.setTextColor(Color.rgb(102, 102, 102));
//                        tabHost.setCurrentTabByTag(RWEnum.YCKB_Value);
//                        break;
//                    case R.id.indexs_activity_yuanchengfuzhu:
//                        rbAnBao.setTextColor(Color.rgb(102, 102, 102));
//                        rbYuanCheng.setTextColor(Color.rgb(10, 170, 249));
//                        tabHost.setCurrentTabByTag(RWEnum.WCKB_Value);
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//
//    }
//
//
//    private void addTab() {
//
//        tabHost = this.getTabHost();
//
//        Intent intent = new Intent(this, HomeActivity.class);
//        Bundle bundle = getBundle(RWEnum.YCKB_Value);
//        intent.putExtra("bundle", bundle);
//        TabHost.TabSpec spec = tabHost.newTabSpec(RWEnum.YCKB_Value).setIndicator(RWEnum.YCKB_Value).setContent(intent);
//        tabHost.addTab(spec);
//
//        intent = new Intent(this, MyActivity.class);
//        bundle = getBundle(RWEnum.WCKB_Value);
//        intent.putExtra("bundle", bundle);
//        spec = tabHost.newTabSpec(RWEnum.WCKB_Value).setIndicator(RWEnum.WCKB_Value).setContent(intent);
//        tabHost.addTab(spec);
//
//    }
//
//    private Bundle getBundle(String cbzt) {
//        Bundle bundle = new Bundle();
//        bundle.putString("cbzt", cbzt);
//        return bundle;
//    }
//
//
//    private boolean isExit=false;
//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        if (event.getKeyCode()== KeyEvent.KEYCODE_BACK) {
//            if (event.getAction()== KeyEvent.ACTION_DOWN&&event.getRepeatCount()==0) {
//                if (isExit) {
//                    System.exit(0);
//                } else {
//                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
//                    isExit=true;
//                    new Handler().postDelayed(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            isExit=false;
//
//                        }
//                    }, 2000);
//                }
//                return true;
//            }
//        }
//        return super.dispatchKeyEvent(event);
//    }






}

