DROP TABLE IF EXISTS MENU;

CREATE TABLE MENU (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    price INT NOT NULL,
    imageUrl VARCHAR(500)
);

INSERT INTO MENU (name, description, price, imageUrl)
VALUES (
    '불고기',
    '우리 가게에서 가장 맛있는 메뉴',
    11500,
    'http://example.com/bulgogi.jpg'
);

SELECT * FROM MENU;
