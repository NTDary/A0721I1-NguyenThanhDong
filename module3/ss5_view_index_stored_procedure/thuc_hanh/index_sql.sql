SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 

-- Bằng lệnh này bạn sẽ nhận ra được với câu Query của bạn, điều gì đang xảy ra và kiểu kết hợp (Join) nào đang diễn ra bên trong.
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';

-- Các bạn thêm chỉ mục cho bảng customers như sau:
ALTER TABLE customers ADD INDEX idx_customerName(customerName);
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';	
-- type : Đây là thông tin quan trọng, nó cho chúng ta biết kiểu query nào nó đang sử dụng. Mức độ từ tốt nhất đến chậm nhất như sau: system, const, eq_ref, ref, range, index, all
-- possible_keys : Đưa ra những Index có thể sử dụng để query
-- key : và Index nào đang được sử dụng
-- key_len : Chiều dài của từng mục trong Index
-- ref : Cột nào đang sử dụng
-- rows : Số hàng (rows) mà MySQL dự đoán phải tìm
-- extra : Thông tin phụ, thật tệ nếu tại cột này là “using temporary” hay “using filesort”

-- Vậy câu hỏi đặt ra là, nếu tôi muốn thêm Index cho những cột mà có thể có nhiều hơn 1 kết quả khi query thì sao?

-- Bạn có thể Add index theo cặp như bạn add index cho cặp contactFirstName và contactLastName.

ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';

-- Để xoá chỉ mục trong bảng, bạn làm như sau:

ALTER TABLE customers DROP INDEX idx_full_name;