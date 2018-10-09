/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Pholo Benny
 * Created: 05 Sep 2018
 */

-- 
use haleComforters;

CREATE TABLE orders (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     amount double(40,2) NOT NULL,
     size VARCHAR(40)NOT NULL,
     name VARCHAR(40) NOT NULL,
     cellnumber VARCHAR(11) NOT NULL,
     PRIMARY KEY (id)
);
