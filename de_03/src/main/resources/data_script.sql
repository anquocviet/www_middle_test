-- ----------------------------
-- Records of loai_xe
-- ----------------------------
BEGIN;
INSERT INTO `loai_xe` (`ma_loai`, `ten_loai`) VALUES ('1', 'Xe so');
INSERT INTO `loai_xe` (`ma_loai`, `ten_loai`) VALUES ('2', 'Xe tay ga');
COMMIT;

BEGIN;
INSERT INTO `xe` (`ma_xe`, `GIA`, `nam_sx`, `ten_xe`, `ma_loai`) VALUES (1, 20000000, 2023, 'Sirius', '1');
INSERT INTO `xe` (`ma_xe`, `GIA`, `nam_sx`, `ten_xe`, `ma_loai`) VALUES (2, 100000000, 2024, 'SH', '2');
COMMIT;