-- 土地资源表
DROP TABLE IF EXISTS land;
CREATE TABLE land
(
    land_id                INT PRIMARY KEY AUTO_INCREMENT, -- 土地编号
    location               VARCHAR(255),                   -- 地理位置
    area                   DECIMAL(10, 2),                 -- 土地面积（单位：平方米）
    topography             VARCHAR(100),                   -- 土地形态
    soil_type              VARCHAR(100),                   -- 土壤类型
    ownership              VARCHAR(100),                   -- 土地所有权
    land_use               VARCHAR(100),                   -- 土地用途
    ecological_environment TEXT,                           -- 土地生态环境描述
    market_value           DECIMAL(12, 2),                 -- 土地市场价值
    planning_use           VARCHAR(100),                   -- 土地规划用途
    owner_intent           TEXT                            -- 土地所有者的意愿和目标
)engine=innodb default charset=utf8mb4;

-- 作物种植计划表
DROP TABLE IF EXISTS crop_planting_plan;
CREATE TABLE crop_planting_plan
(
    plan_id           INT PRIMARY KEY AUTO_INCREMENT, -- 计划编号
    farm_id           INT,                            -- 农场/农户编号
    year              INT,                            -- 年度
    season            VARCHAR(50),                    -- 季节
    plot_id           INT,                            -- 地块编号
    crop_type         VARCHAR(100),                   -- 作物种类
    planting_area     DECIMAL(10, 2),                 -- 种植面积（单位：平方米）
    expected_yield    DECIMAL(12, 2),                 -- 预计产量（单位：公斤）
    planting_date     DATE,                           -- 种植日期
    harvest_date      DATE,                           -- 预计收获日期
    planting_method   VARCHAR(100),                   -- 种植方法
    fertilizer_usage  VARCHAR(255),                   -- 肥料使用情况
    pesticide_usage   VARCHAR(255),                   -- 农药使用情况
    irrigation_method VARCHAR(100),                   -- 灌溉方式
    notes             TEXT                            -- 其他备注
)engine=innodb default charset=utf8mb4;

-- 灌溉系统设计表
DROP TABLE IF EXISTS irrigation_system_design;
CREATE TABLE irrigation_system_design
(
    system_id          INT PRIMARY KEY AUTO_INCREMENT, -- 系统编号
    system_name        VARCHAR(100),                   -- 系统名称
    system_type        VARCHAR(100),                   -- 系统类型
    farm_id            INT,                            -- 农场/农户编号
    system_area        DECIMAL(10, 2),                 -- 系统面积（单位：平方米）
    water_source       VARCHAR(100),                   -- 灌溉水源
    pump_type          VARCHAR(100),                   -- 水泵类型
    pump_power         DECIMAL(10, 2),                 -- 水泵功率（单位：千瓦）
    pipeline_material  VARCHAR(100),                   -- 管道材质
    pipeline_diameter  DECIMAL(10, 2),                 -- 管道直径（单位：毫米）
    irrigation_plan_id INT,                            -- 灌溉计划编号
    installation_date  DATE,                           -- 安装日期
    maintenance_record TEXT,                           -- 维护记录
    notes              TEXT                            -- 备注
)engine=innodb default charset=utf8mb4;

-- 气象数据表
DROP TABLE IF EXISTS meteorological_data;
CREATE TABLE meteorological_data
(
    data_id           INT PRIMARY KEY AUTO_INCREMENT, -- 数据编号
    station_id        INT,                            -- 气象站编号
    observation_time  DATETIME,                       -- 观测时间
    temperature       DECIMAL(5, 2),                  -- 温度（摄氏度）
    humidity          DECIMAL(5, 2),                  -- 湿度（百分比）
    precipitation     DECIMAL(7, 2),                  -- 降水量（毫米）
    wind_speed        DECIMAL(6, 2),                  -- 风速（米/秒）
    wind_direction    VARCHAR(50),                    -- 风向
    pressure          DECIMAL(8, 2),                  -- 气压（百帕）
    visibility        DECIMAL(6, 2),                  -- 能见度（公里）
    cloud_cover       DECIMAL(5, 2),                  -- 云量（百分比）
    weather_condition VARCHAR(100),                   -- 天气状况描述
    notes             TEXT                            -- 备注
)engine=innodb default charset=utf8mb4;

-- 土壤监测表
DROP TABLE IF EXISTS soil_test_data;
CREATE TABLE soil_test_data
(
    test_id        INT PRIMARY KEY AUTO_INCREMENT, -- 检测编号
    location       VARCHAR(255),                   -- 检测地点
    test_date      DATE,                           -- 检测日期
    ph_level       DECIMAL(5, 2),                  -- pH值
    nitrogen       DECIMAL(8, 2),                  -- 氮含量（单位：mg/kg）
    phosphorus     DECIMAL(8, 2),                  -- 磷含量（单位：mg/kg）
    potassium      DECIMAL(8, 2),                  -- 钾含量（单位：mg/kg）
    organic_matter DECIMAL(8, 2),                  -- 有机物含量（单位：百分比）
    texture        VARCHAR(100),                   -- 土壤质地
    salinity       DECIMAL(8, 2),                  -- 盐分含量（单位：毫克/千克）
    drainage       VARCHAR(50),                    -- 排水情况
    soil_type      VARCHAR(100),                   -- 土壤类型
    notes          TEXT                            -- 备注
)engine=innodb default charset=utf8mb4;

-- 作物生长状况跟踪表
DROP TABLE IF EXISTS crop_growth_tracking;
CREATE TABLE crop_growth_tracking
(
    tracking_id         INT PRIMARY KEY AUTO_INCREMENT, -- 跟踪编号
    farm_id             INT,                            -- 农场/农户编号
    plot_id             INT,                            -- 地块编号
    crop_type           VARCHAR(100),                   -- 作物种类
    growth_stage        VARCHAR(100),                   -- 生长阶段
    observation_date    DATE,                           -- 观测日期
    height              DECIMAL(8, 2),                  -- 高度（单位：厘米）
    canopy_width        DECIMAL(8, 2),                  -- 冠幅宽度（单位：厘米）
    leaf_color          VARCHAR(50),                    -- 叶片颜色
    pest_presence       VARCHAR(100),                   -- 害虫存在情况
    disease_presence    VARCHAR(100),                   -- 病害存在情况
    nutrient_deficiency VARCHAR(100),                   -- 养分缺乏情况
    soil_moisture       DECIMAL(8, 2),                  -- 土壤湿度（单位：百分比）
    notes               TEXT                            -- 备注
)engine=innodb default charset=utf8mb4;

-- 农产品表
DROP TABLE IF EXISTS agricultural_product;
CREATE TABLE agricultural_product
(
    product_id         INT PRIMARY KEY AUTO_INCREMENT, -- 产品编号
    product_name       VARCHAR(255),                   -- 产品名称
    category           VARCHAR(100),                   -- 产品类别
    description        TEXT,                           -- 产品描述
    origin             VARCHAR(255),                   -- 产地
    harvest_date       DATE,                           -- 收获日期
    quantity           DECIMAL(10, 2),                 -- 数量
    unit               VARCHAR(50),                    -- 单位
    price              DECIMAL(10, 2),                 -- 单价（单位：元）
    expiration_date    DATE,                           -- 过期日期
    storage_conditions TEXT                            -- 存储条件
)engine=innodb default charset=utf8mb4;

-- 农产品销售表
DROP TABLE IF EXISTS agricultural_product_sales;
CREATE TABLE agricultural_product_sales
(
    sale_id           INT PRIMARY KEY AUTO_INCREMENT, -- 销售编号
    product_id        INT,                            -- 产品编号
    sale_date         DATE,                           -- 销售日期
    quantity          DECIMAL(10, 2),                 -- 销售数量
    unit_price        DECIMAL(10, 2),                 -- 单价（单位：元）
    total_price       DECIMAL(12, 2),                 -- 总价（单位：元）
    customer_name     VARCHAR(255),                   -- 客户姓名
    customer_contact  VARCHAR(255),                   -- 客户联系方式
    payment_method    VARCHAR(100),                   -- 付款方式
    delivery_address  VARCHAR(255),                   -- 送货地址
    customer_feedback TEXT                            -- 客户反馈
)engine=innodb default charset=utf8mb4;





