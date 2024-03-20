-- 土地资源表
DROP TABLE IF EXISTS land;
CREATE TABLE land
(
    land_id                INT PRIMARY KEY AUTO_INCREMENT, -- 土地编号
    location               VARCHAR(255),                   -- 地理位置
    area                   DECIMAL(10, 2),                 -- 土地面积（单位：平方米）
    topography             VARCHAR(100),                   -- 土地形态
    soil_type              VARCHAR(100),                   -- 土壤类型
    ownership              BIGINT(20),                     -- 土地所有者
    land_use               VARCHAR(100),                   -- 土地用途
    ecological_environment TEXT,                           -- 土地生态环境描述
    market_value           DECIMAL(12, 2),                 -- 土地市场价值
    planning_use           VARCHAR(100),                   -- 土地规划用途
    owner_intent           TEXT                            -- 土地所有者的意愿和目标
)engine=innodb default charset=utf8mb4;

INSERT INTO land (location, area, topography, soil_type, ownership, land_use, ecological_environment, market_value,
                  planning_use, owner_intent)
VALUES ('北京市朝阳区', 1000.50, '平原', '红壤', 1, '农田', '地势平坦，适合种植作物', 5000000.00, '农业用地', '希望种植粮食，增加收益'),
       ('上海市浦东新区', 800.75, '丘陵', '黑土', 2, '工业用地', '周边环境适合工业发展', 8000000.00, '工业用地', '计划建设厂房和仓储设施'),
       ('广州市番禺区', 600.25, '山地', '黄土', 3, '住宅用地', '风景优美，适合居住', 10000000.00, '住宅用地', '打造度假别墅');

-- 作物种植计划表
DROP TABLE IF EXISTS crop_planting_plan;
CREATE TABLE crop_planting_plan
(
    plan_id          INT PRIMARY KEY AUTO_INCREMENT, -- 计划编号
    farm_id          INT,                            -- 农场/农户编号
    year             INT,                            -- 年度
    season           VARCHAR(50),                    -- 季节
    land_id          INT references land (land_id),  -- 地块编号
    crop_type        VARCHAR(100),                   -- 作物种类
    planting_area    DECIMAL(10, 2),                 -- 种植面积（单位：平方米）
    expected_yield   DECIMAL(12, 2),                 -- 预计产量（单位：公斤）
    planting_date    DATE,                           -- 种植日期
    harvest_date     DATE,                           -- 预计收获日期
    planting_method  VARCHAR(100),                   -- 种植方法
    fertilizer_usage VARCHAR(255),                   -- 肥料使用情况
    pesticide_usage  VARCHAR(255),                   -- 农药使用情况
    notes            TEXT                            -- 其他备注
)engine=innodb default charset=utf8mb4;

INSERT INTO crop_planting_plan (farm_id, year, season, land_id, crop_type, planting_area, expected_yield, planting_date,
                                harvest_date, planting_method, fertilizer_usage, pesticide_usage, notes)
VALUES (1, 2024, '春季', 1, '小麦', 500.00, 1000.00, '2024-03-01', '2024-06-01', '直播', 'NPK化肥，每亩用量10kg', '除草剂，每亩用量5kg',
        '第一季度作物种植计划'),
       (2, 2024, '春季', 2, '玉米', 800.00, 2000.00, '2024-03-15', '2024-07-15', '插秧', '复合肥，每亩用量15kg', '杀虫剂，每亩用量8kg',
        '第一季度作物种植计划'),
       (3, 2024, '春季', 3, '水稻', 600.00, 1500.00, '2024-04-01', '2024-07-30', '直播', '有机肥，每亩用量20kg', '杀虫剂，每亩用量10kg',
        '第一季度作物种植计划');

-- 灌溉记录表
DROP TABLE IF EXISTS irrigation_record;
CREATE TABLE irrigation_record
(
    irrigation_id       INT PRIMARY KEY AUTO_INCREMENT, -- 灌溉编号
    farm_id             BIGINT(20),                     -- 农场/农户编号
    land_id             INT references land (land_id),  -- 地块编号
    irrigation_date     DATE,                           -- 灌溉日期
    irrigation_duration DECIMAL(8, 2),                  -- 灌溉时长（单位：小时）
    water_consumption   DECIMAL(10, 2),                 -- 水消耗量（单位：立方米）
    irrigation_method   VARCHAR(100),                   -- 灌溉方式
    notes               TEXT                            -- 备注
) engine=innodb default charset=utf8mb4;

INSERT INTO irrigation_record (farm_id, land_id, irrigation_date, irrigation_duration, water_consumption,
                               irrigation_method, notes)
VALUES (1, 1, '2024-03-05', 2.5, 10.0, '喷灌', '地块1进行了喷灌，持续时间2.5小时，消耗10立方米水'),
       (2, 2, '2024-03-10', 3.0, 12.0, '滴灌', '地块2进行了滴灌，持续时间3小时，消耗12立方米水'),
       (3, 3, '2024-03-15', 2.0, 8.0, '喷灌', '地块3进行了喷灌，持续时间2小时，消耗8立方米水');

-- 土壤监测表
DROP TABLE IF EXISTS soil_test_data;
CREATE TABLE soil_test_data
(
    test_id        INT PRIMARY KEY AUTO_INCREMENT, -- 检测编号
    location       INT references land (land_id),  -- 检测地块
    test_date      DATE,                           -- 检测日期
    ph_level       DECIMAL(5, 2),                  -- pH值
    nitrogen       DECIMAL(8, 2),                  -- 氮含量（单位：mg/kg）
    phosphorus     DECIMAL(8, 2),                  -- 磷含量（单位：mg/kg）
    potassium      DECIMAL(8, 2),                  -- 钾含量（单位：mg/kg）
    organic_matter DECIMAL(8, 2),                  -- 有机物含量（单位：百分比）
    texture        VARCHAR(100),                   -- 土壤质地
    salinity       DECIMAL(8, 2),                  -- 盐分含量（单位：毫克/千克）
    soil_moisture  DECIMAL(8, 2),                  -- 土壤湿度（单位：百分比）
    soil_type      VARCHAR(100),                   -- 土壤类型
    notes          TEXT                            -- 备注
)engine=innodb default charset=utf8mb4;

INSERT INTO soil_test_data (location, test_date, ph_level, nitrogen, phosphorus, potassium, organic_matter, texture,
                            salinity, soil_moisture, soil_type, notes)
VALUES (1, '2024-03-01', 6.5, 20.0, 15.0, 10.0, 3.5, '壤土', 0.8, 25.0, '红壤', '第一次土壤检测结果'),
       (2, '2024-03-05', 7.0, 18.0, 12.0, 8.0, 2.8, '粘土', 0.6, 30.0, '黑土', '第一次土壤检测结果'),
       (3, '2024-03-10', 6.8, 22.0, 14.0, 9.0, 3.0, '沙土', 0.7, 28.0, '黄土', '第一次土壤检测结果');

-- 作物生长状况跟踪表
DROP TABLE IF EXISTS crop_growth_tracking;
CREATE TABLE crop_growth_tracking
(
    tracking_id         INT PRIMARY KEY AUTO_INCREMENT, -- 跟踪编号
    farm_id             INT,                            -- 农场/农户编号
    land_id             INT references land (land_id),  -- 地块编号
    crop_type           VARCHAR(100),                   -- 作物种类
    growth_stage        VARCHAR(100),                   -- 生长阶段
    observation_date    DATE,                           -- 观测日期
    height              DECIMAL(8, 2),                  -- 高度（单位：厘米）
    canopy_width        DECIMAL(8, 2),                  -- 冠幅宽度（单位：厘米）
    leaf_color          VARCHAR(50),                    -- 叶片颜色
    pest_presence       VARCHAR(100),                   -- 害虫存在情况
    disease_presence    VARCHAR(100),                   -- 病害存在情况
    nutrient_deficiency VARCHAR(100),                   -- 养分缺乏情况
    notes               TEXT                            -- 备注
)engine=innodb default charset=utf8mb4;

INSERT INTO crop_growth_tracking (farm_id, land_id, crop_type, growth_stage, observation_date, height, canopy_width,
                                  leaf_color, pest_presence, disease_presence, nutrient_deficiency, notes)
VALUES (1, 1, '小麦', '生长期', '2024-03-01', 30.5, 40.2, '绿色', '无', '无', '无', '第一次观测结果'),
       (2, 2, '玉米', '生长期', '2024-03-05', 40.8, 55.0, '深绿色', '轻微', '无', '缺铁', '第一次观测结果'),
       (3, 3, '水稻', '生长期', '2024-03-10', 25.3, 38.6, '浅绿色', '无', '病毒感染', '缺钾', '第一次观测结果');

-- 农产品表
DROP TABLE IF EXISTS agricultural_product;
CREATE TABLE agricultural_product
(
    product_id         INT PRIMARY KEY AUTO_INCREMENT, -- 产品编号
    product_name       VARCHAR(255),                   -- 产品名称
    harvest_date       DATE,                           -- 收获日期
    quantity           DECIMAL(10, 2),                 -- 当前数量
    totality           DECIMAL(10, 2),                 -- 总量
    unit               VARCHAR(50),                    -- 单位
    price              DECIMAL(10, 2),                 -- 单价（单位：元）
    expiration_date    DATE,                           -- 过期日期
    storage_conditions TEXT                            -- 存储条件
)engine=innodb default charset=utf8mb4;

INSERT INTO agricultural_product (product_name, harvest_date, quantity, totality, unit, price, expiration_date,
                                  storage_conditions)
VALUES ('小麦', '2024-06-01', 500.00, 1000.00, '公斤', 2.50, '2025-06-01', '存放在阴凉通风的地方，避免阳光直射'),
       ('玉米', '2024-07-15', 800.00, 2000.00, '公斤', 2.80, '2025-07-15', '存放在干燥通风处，避免潮湿和高温'),
       ('水稻', '2024-07-30', 600.00, 1500.00, '公斤', 3.00, '2025-07-30', '存放在阴凉干燥处，避免受潮和受虫害');

-- 农产品价格爬取表
DROP TABLE IF EXISTS agricultural_product_price;
CREATE TABLE agricultural_product_price
(
    product_id   INT references agricultural_product (product_id), -- 产品编号
    product_name VARCHAR(255),                                     -- 产品名称
    description  TEXT,                                             -- 描述
    unit         VARCHAR(50),                                      -- 单位
    price        DECIMAL(10, 2)                                   -- 单价（单位：元）
)engine=innodb default charset=utf8mb4;

INSERT INTO agricultural_product_price (product_id, product_name, description, unit, price)
VALUES
    (1, '小麦', '新鲜小麦价格', '公斤', 2.50),
    (2, '玉米', '新鲜玉米价格', '公斤', 2.80),
    (3, '水稻', '新鲜水稻价格', '公斤', 3.00);


-- 农产品销售表
DROP TABLE IF EXISTS agricultural_product_sales;
CREATE TABLE agricultural_product_sales
(
    sale_id           INT PRIMARY KEY AUTO_INCREMENT,                   -- 销售编号
    product_id        INT references agricultural_product (product_id), -- 产品编号
    sale_date         DATE,                                             -- 销售日期
    quantity          DECIMAL(10, 2),                                   -- 销售数量
    unit_price        DECIMAL(10, 2),                                   -- 单价（单位：元）
    total_price       DECIMAL(12, 2),                                   -- 总价（单位：元）
    customer_name     VARCHAR(255),                                     -- 客户姓名
    customer_contact  VARCHAR(255),                                     -- 客户联系方式
    payment_method    VARCHAR(100),                                     -- 付款方式
    delivery_address  VARCHAR(255),                                     -- 送货地址
    customer_feedback TEXT                                              -- 客户反馈
)engine=innodb default charset=utf8mb4;

INSERT INTO agricultural_product_sales (product_id, sale_date, quantity, unit_price, total_price, customer_name, customer_contact, payment_method, delivery_address, customer_feedback)
VALUES
    (1, '2024-06-10', 200.00, 2.50, 500.00, '张三', '13812345678', '现金', '北京市朝阳区', '产品质量很好，谢谢！'),
    (2, '2024-07-20', 300.00, 2.80, 840.00, '李四', '13998765432', '支付宝', '上海市浦东新区', '配送及时，服务态度好'),
    (3, '2024-08-05', 400.00, 3.00, 1200.00, '王五', '13611112222', '微信', '广州市番禺区', '价格实惠，下次还会购买');






