package com.example.music_app.bean;

public class Chat {

    private Long id;

    public Long createTime;  // 创建时间

    public String firstQuestion;  // 首条提问
    public String firstAnswer;  // 首条回答
    public String character;  // 角色
    public String prologue;  // 出场白

    public Chat(Long id, Long createTime, String firstQuestion, String firstAnswer,
                String character, String prologue) {
        this.id = id;
        this.createTime = createTime;
        this.firstQuestion = firstQuestion;
        this.firstAnswer = firstAnswer;
        this.character = character;
        this.prologue = prologue;
    }

    public Chat() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public String getFirstQuestion() {
        return this.firstQuestion;
    }
    public void setFirstQuestion(String firstQuestion) {
        this.firstQuestion = firstQuestion;
    }
    public String getFirstAnswer() {
        return this.firstAnswer;
    }
    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }
    public String getCharacter() {
        return this.character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    public String getPrologue() {
        return this.prologue;
    }
    public void setPrologue(String prologue) {
        this.prologue = prologue;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", firstQuestion='" + firstQuestion + '\'' +
                ", firstAnswer='" + firstAnswer + '\'' +
                ", character='" + character + '\'' +
                ", prologue='" + prologue + '\'' +
                '}';
    }
}
