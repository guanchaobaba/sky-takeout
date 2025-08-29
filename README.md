# 苍穹外卖 - 校园餐饮外卖系统

## 项目简介

苍穹外卖是一款为大学校园设计的餐饮外卖服务平台，提供餐饮企业管理和用户点餐全流程解决方案。系统包含**管理后台**（供餐厅员工使用）和
**微信小程序**（供消费者使用）两部分，实现了从菜品管理、订单处理到数据统计的完整功能闭环。

## ✨ 功能特性

### 管理端功能

- **员工管理**：员工信息维护、权限控制
- **分类管理**：菜品分类与套餐分类维护
- **菜品管理**：菜品信息维护、启售停售控制
- **套餐管理**：套餐组合与促销管理
- **订单管理**：订单处理、状态跟踪、订单报表
- **数据统计**：营业额、用户量、订单量等多维度数据可视化分析
- **来单提醒**：WebSocket实时来单语音播报

### 用户端功能（微信小程序）

- **微信登录**：一键授权快速登录
- **菜品浏览**：分类浏览菜品与套餐
- **购物车管理**：添加、删除、清空购物车
- **下单支付**：在线下单与支付集成
- **订单管理**：历史订单查询、订单状态跟踪
- **地址管理**：收货地址维护
- **催单功能**：实时催单通知

## 🛠 技术栈

### 后端技术

- **Spring Boot**：快速开发框架
- **Spring MVC**：Web层MVC框架
- **Spring Task**：定时任务调度
- **JWT**：身份认证与授权
- **Spring Cache**：缓存抽象层
- **HttpClient**：HTTP请求处理

### 数据层

- **MySQL**：关系型数据库
- **MyBatis**：ORM框架
- **PageHelper**：MyBatis分页插件
- **Redis**：缓存与会话管理
- **Spring Data Redis**：Redis操作封装

### 前端技术

- **Vue.js**：前端框架
- **ElementUI**：UI组件库
- **微信小程序**：移动端应用

### 中间件与服务

- **Nginx**：反向代理与负载均衡
- **阿里云OSS**：对象存储服务（菜品图片）
- **WebSocket**：实时通信（来单提醒、催单）
- **Swagger**：API文档生成
- **Apache ECharts**：数据可视化

## 🚀 安装指南

### 环境要求

- JDK 17+
- MySQL 8.0+
- Redis 5.0+
- Maven 3.6+
- Node.js 12+（前端构建）

### 后端部署

1. **克隆项目**
   ```bash
   git clone https://github.com/guanchaobaba/sky-take-out.git
   cd sky-take-out
   ```

2. **数据库配置**
    - 创建MySQL数据库`sky_take_out`
    - 执行项目根目录下的`sky.sql`文件初始化数据表

3. **配置文件修改**
    - 修改`sky-server/src/main/resources/application.yml`中的数据库和Redis连接信息
    - 配置阿里云OSS访问密钥（如需要）

4. **启动项目**
   ```bash
   mvn clean package
   java -jar sky-server/target/sky-server-1.0-SNAPSHOT.jar
   ```

### 前端部署

1. **管理端前端**
    - 安装依赖：`npm install`
    - 开发环境运行：`npm run dev`
    - 构建生产包：`npm run build`

2. **微信小程序**
    - 使用微信开发者工具导入小程序项目
    - 配置小程序AppID和服务器地址
    - 上传审核并发布

## 📖 使用说明

### 管理端访问

1. 启动后端服务后，访问`http://localhost:8080/admin`
2. 使用默认账号登录（如：admin/123456）

### API接口测试

项目集成Swagger，访问`http://localhost:8080/doc.html`查看和测试API接口

### 小程序使用

1. 微信搜索或扫描二维码打开"苍穹外卖"小程序
2. 授权微信登录
3. 开始浏览菜品、下单支付

## 📁 项目结构

```
sky-take-out/
├── sky-common          # 公共模块
├── sky-pojo            # 实体类模块
├── sky-server          # 服务端模块
│   ├── config          # 配置类
│   ├── controller      # 控制层
│   ├── service         # 服务层
│   ├── mapper          # 数据访问层
│   └── resources       # 资源文件
├── sky-web             # 管理端前端
└── sky-applet          # 微信小程序端
```

## ⚙️ 配置说明

### 关键配置项

```yaml
# 数据库配置
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url:
    username:
    password:

  # Redis配置
  redis:
    host: localhost
    port: 6379
    password:
    database:

# JWT配置
jwt:
  admin-secret-key: sky-take-out
  admin-ttl: 
```

## ❓ 常见问题

1. **无法连接数据库**
    - 检查MySQL服务是否启动
    - 确认application.yml中的数据库连接信息正确

2. **Redis连接失败**
    - 检查Redis服务是否启动
    - 确认防火墙设置

3. **小程序无法请求接口**
    - 确认小程序配置的服务器域名正确
    - 检查Nginx反向代理配置

## 🤝 贡献指南

欢迎提交Issue和Pull Request参与项目改进：

1. Fork本仓库
2. 创建功能分支：`git checkout -b feature/YourFeature`
3. 提交更改：`git commit -am 'Add some feature'`
4. 推送到分支：`git push origin feature/YourFeature`
5. 提交Pull Request

## 📄 许可证

本项目基于MIT许可证发布，详情参见LICENSE文件。

## 👥 联系方式

- **项目负责人**：Chao
- **邮箱**：guanchaobaba@gmail.com

## 🙏 致谢

感谢以下开源项目和技术：

- https://spring.io/projects/spring-boot
- https://vuejs.org/
- https://developers.weixin.qq.com/miniprogram/dev/
