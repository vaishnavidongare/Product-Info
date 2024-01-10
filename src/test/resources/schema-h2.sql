CREATE TABLE `productlines` (
  `product_line` varchar(255) NOT NULL,
  `html_description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `text_description` varchar(255) DEFAULT NULL
) 

CREATE TABLE `products` (
  `product_code` varchar(255) NOT NULL,
  `buy_price` int(11) DEFAULT NULL,
  `msrp` int(11) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_scale` varchar(255) DEFAULT NULL,
  `product_vendor` varchar(255) DEFAULT NULL,
  `quantity_in_stock` int(11) DEFAULT NULL,
  `p_line` varchar(255) DEFAULT NULL
)