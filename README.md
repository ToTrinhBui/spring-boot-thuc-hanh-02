# spring-boot-thuc-hanh-02

# nhóm 18:
1. Bùi Tố Trinh
2. Nguyễn Thị Thanh Nhàn
3. Trần Thị Ngọc Nhung

# Mô tả 
1. Enity
- Product: với 3 thuộc tính: productCode(primary key), productDescripttion, productPrice
3. Controller
- HomeController: url("/") GetMapping hiển thị trả về giao diện index.html
- ProducrController:
+ url("/products") GetMapping hiển thị trả về giao diện products.html hiển thị các sản phẩm
+ url("/products/add") GetMapping hiển thị trả về giao diện addProduct.html
+ url("/products/editForm") GetMapping hiển thị trả về giao diện editProduct.html với từng sản phẩm tương ứng với code của sản phẩm và lấy thông tin hiển thị sản phẩm đấy từ database. Sau đấy, ta sửa thông tin sản phẩm và lưu lại bằng cách ấn Submit(PostMapping với url("/products/edit") để lưu cập nhập sản phẩm)
+ url("/products/cornfirmDelete") GetMapping hiển thị trả về giao diện deleteProduct.html với từng sản phẩm tương ứng với code của sản phẩm và lấy thông tin hiển thị sản phẩm đấy từ database. Sau đấy, ta xác nhận xóa sản phẩm và lưu lại bằng cách ấn Yes(PostMapping với url("/products/delete") để xóa sản phẩm)
+ url("/products/delete") PostMapping xóa sản phẩm và trả về giao diện products.html
+ url("/products/save") PostMapping lưu sản phẩm và trả về giao diện addProductSuccess.html
+ url("/products/edit") PostMapping lưu cập nhập sản phẩm và trả về giao diện products.html
4. Data
- ProducRepository: extends CrudRepository
- Kết nối tới database productcloud từ MySQL(chi tiết tại application.properties)
5. Templates
- addProduct.html : hiển thị form thêm sản phẩm
- addProductSuccess.html : hiện thị trang xác nhận thêm sản phẩm thành công
- deleteProduct.html : hiển thị form xác nhận xóa sản phẩm
- editProduct.html : hiển thị form edit sản phẩm
- index.html : hiển thị trang home
- products.html : hiển thị các sản phẩm

