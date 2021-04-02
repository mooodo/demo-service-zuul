# demo-service-zuul
这是一个项目用于演示微服务的服务网关zuul，服务网关是微服务系统与外部用户交互的唯一出口。外部用户在访问系统时，服务网关通过智能路由，将请求转发到不同的微服务上。

本示例通过以下配置进行智能路由：
```bash
  routes:
    customer:
      path: /customer/**
      serviceId: service-customer
      stripPrefix: true

    product:
      path: /product/**
      serviceId: service-product
      stripPrefix: true

    supplier:
      path: /supplier/**
      serviceId: service-supplier
      stripPrefix: true
```
比如，用户访问的url是`http://localhost:9008/customer/orm/customer/load?id=10002`，通过智能路由，服务网关就将该访问转发到`service-customer`中。由于配置设定的是`stripPrefix: true`，服务网关请求微服务的url就会去掉`/customer`的头，就变为`/orm/customer/load?id=10002`，这正是该微服务对外开放的API接口。

本示例可以从客户端访问的服务：
```bash

service-zuul:
curl -X POST http://localhost:9008/customer/query/customerQry

curl http://localhost:9008/customer/orm/customer/load?id=10002

curl -X POST http://localhost:9008/customer/orm/customer/save -d "id=40005&name=John&sex=male&birthday=2013-07-08&identification=110212201307083814&phoneNumber=13477496662"

curl http://localhost:9008/customer/orm/customer/delete?id=40005

curl -X POST http://localhost:9008/product/query/productQry

curl http://localhost:9008/customer/orm/product/getProduct?id=30001

curl -X POST http://localhost:9008/product/orm/product/saveProduct -d "id=40006&name=ThinkPad+T220&price=4600&unit=%E4%B8%AA&supplierId=S0002&classify=%E5%8A%9E%E5%85%AC%E7%94%A8%E5%93%81"

curl http://localhost:9003/orm/product/deleteProduct?id=40006

curl http://localhost:9008/supplier/orm/supplier/loadSupplier?id=20002

curl http://localhost:9008/supplier/orm/supplier/listOfSuppliers
```