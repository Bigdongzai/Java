package com.xhd.entity;


import lombok.Data;

import java.util.List;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 15:57
 * 版本: V1.0
 */
@Data
public class ChoiceQuestionEntity {
    private Long id;
    private String choiceQuestionProblem;
    private List<String> answers;
    private String choiceQuestionCorrectAnswer;


}
