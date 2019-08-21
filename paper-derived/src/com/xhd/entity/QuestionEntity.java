package com.xhd.entity;


import java.util.List;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 19:36
 * 版本: V1.0
 */
public class QuestionEntity {
    //主键
    private Long id;
    //题型
    private String questionType;
    //题干
    private String problem;
    //选项 针对单选、多选
    private List<String> options;
    //答案
    private String answer;
    //分值
    private Double score;
    //考点
    private String testingCentre;
    //段位
    private String danGrading;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getTestingCentre() {
        return testingCentre;
    }

    public void setTestingCentre(String testingCentre) {
        this.testingCentre = testingCentre;
    }

    public String getDanGrading() {
        return danGrading;
    }

    public void setDanGrading(String danGrading) {
        this.danGrading = danGrading;
    }
}
