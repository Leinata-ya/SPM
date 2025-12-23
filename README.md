SPM - 智慧党建/成员管理系统
📝 项目简介
本项目是一个基于 Java Web 技术栈开发的轻量级管理系统。系统采用典型的 MVC (Model-View-Controller) 架构设计，通过 DAO 模式 进行数据库交互，实现了从用户注册、登录到复杂的成员审批与学习数据管理等全流程功能。

🚀 核心功能模块
身份认证系统：包含 LoginServlet 与 RegisterServlet，提供安全的用户登录与账号注册功能。

成员信息管理：通过 PartyMember 模型与 UserServlet，实现对系统中人员信息的查询、更新与维护。

审批流转模块：包含专用的审批界面 (shenpi.html) 与后台处理逻辑 (ShenpiServlet)，用于处理系统内的各类申请事项。

学习数据追踪：设有 study.html 与 StudyServlet，记录并展示成员的学习进度与相关数据。

交互式前端：使用原生 JavaScript (app.js, shenpi.js) 提升用户界面的交互体验。

🛠️ 技术栈
后端 (Backend)：Java Servlet, JDBC (使用 MyDbUtils 进行连接管理)。

前端 (Frontend)：JSP, HTML5, CSS3, JavaScript。

构建工具 (Build)：Maven (包含 pom.xml)。

服务器 (Server)：Apache Tomcat 9.0.87。

📂 项目结构说明
Plaintext

SPM/
├── src/main/java/com/example/party/   # 后端源码
│   ├── dao/          # 数据访问层 (UserDao, StudyDao等)
│   ├── service/      # 业务逻辑层 (UserService等)
│   ├── servlet/      # 逻辑控制层 (LoginServlet, RegisterServlet等)
│   └── util/         # 工具类 (MyDbUtils)
├── src/main/webapp/                   # Web 资源目录
│   ├── css/          # 样式表
│   ├── WEB-INF/      # 配置文件 (web.xml)
│   ├── index.jsp     # 系统入口页
│   ├── login.html    # 登录界面
│   ├── register.html # 注册界面
│   └── shenpi.html   # 审批管理页
└── pom.xml                            # Maven 项目依赖配置
⚙️ 环境要求与运行指南
JDK 版本：建议使用 Java 1.8 以确保最佳的驱动兼容性。

应用服务器：推荐使用 Apache Tomcat 9.0.x。

数据库配置：

在 MySQL 中创建相应的数据库。

检查并修改 MyDbUtils.java 中的数据库连接字符串、用户名及密码。

部署步骤：

在 IDEA 中导入项目并配置 Tomcat。

确保 Application Context 设置为 /。

通过浏览器访问 http://localhost:8080/index.jsp。

💡 维护者
Leinata-ya

项目首次提交于 2025 年 12 月 23 日。
