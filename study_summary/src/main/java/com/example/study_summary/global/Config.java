package com.example.study_summary.global;

// 像这种全局的配置，独立定义一个文件好点，方便管理，因为很多时候，我们的配置数据涉及到很多模块
// 可能不止登录这里要用到，有可能其他的模块也需要一些配置数据，放在这里
public interface Config {
    String TANG_POETRY = "tang_poetry";
    String USER_NAME = "user_name";
    String USER_PWD = "user_pwd";
}
