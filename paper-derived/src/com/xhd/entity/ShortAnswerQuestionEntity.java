package com.xhd.entity;

import lombok.Data;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 16:05
 * 版本: V1.0
 */

@Data
public class ShortAnswerQuestionEntity {
    private Long id;
    private String shortAnswerProblem;
    private String referenceAnswer;
}
