<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 23/02/2022
  Time: 01:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <style>

        .styleTable1{
            border-collapse: collapse;
        }
        .styleTable1 td,th{
            border: 1px solid;
        }
        .styleTable1 td input {
            width: unset;
        }


        .styleTable {
            width: 50%;
            margin: auto;
            text-align: center;
        }

        .dot {
            color: red;
            font-style: italic;
        }

        table {
            table-layout: fixed;
            width: 100%;
        }

        input, select {
            width: 100%;
        }
    </style>
</head>
<body>
<div class="styleTable">
    <h3>TỜ KHAI Y TẾ</h3>
    <h4>ĐÂY LÀ TÀI LIỆU QUAN TRONG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
        BỆNH TRUYỀN NHIỄM</h4>
    <p style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
    <br>
    <br>
    <form:form action="send" method="post" modelAttribute="inforToKhaiYTe">
        <table>
            <tr>
                <td colspan="12">Họ tên(ghi chữ IN HOA)<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <td colspan="12"><form:input path="name" required="required"/></td>
            </tr>
            <tr>
                <td colspan="4">Năm sinh<span class="dot">(*)</span></td>
                <td colspan="4">Giới tính<span class="dot">(*)</span></td>
                <td colspan="4">Quốc tịch<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <td colspan="4"><form:input path="year" required="required"/></td>
                <td colspan="4">
                    <form:select path="gender" required="required">
                        <form:option value="" label="--- Chọn ---"  />
                        <form:option value="nam" label="Nam" />
                        <form:option value="nu" label="Nữ" />
                    </form:select>
                </td>
                <td colspan="4">
                    <form:select path="country">
                        <form:option value="vietnam" label="Việt Nam"/>
                        <form:option value="khac" label="Khác"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="12">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span class="dot">(*)</span>
                </td>
            </tr>
            <tr>
                <td colspan="12"><form:input path="idCard" required="required"/></td>
            </tr>
            <tr>
                <td colspan="12">Thông tin đi lại<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <td colspan="12">
                    <form:radiobutton path="nameVehicle" value="Tàu bay" label="Tàu bay" cssStyle="width: auto" required="required"/>
                    <form:radiobutton path="nameVehicle" value="Tàu thuyền" label="Tàu thuyền" cssStyle="width: auto"/>
                    <form:radiobutton path="nameVehicle" value="Ô tô" label="Ô tô" cssStyle="width: auto"/>
                    <form:radiobutton path="nameVehicle" value="Khác" label="Khác(Ghi rõ)" cssStyle="width: auto"/>
                </td>
            </tr>
            <tr>
                <td colspan="6">Số hiệu phương tiện</td>
                <td colspan="6">Số ghế</td>
            </tr>
            <tr>
                <td colspan="6"><form:input path="idVehicle" required="required"/></td>
                <td colspan="6"><form:input path="numberSeats" required="required"/></td>
            </tr>
            <tr>
                <td colspan="6">Ngày khởi hành<span class="dot">(*)</span></td>
                <td colspan="6">Ngày kết thúc<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <td colspan="6"><form:input path="startDay" type="date" required="required"/></td>
                <td colspan="6"><form:input path="endDay" type="date" required="required"/></td>
            </tr>
            <tr>
                <td colspan="12">Trong vòng 14 ngày qua, Anh/chị có đến tỉnh thành phố nào?<span class="dot">(*)</span>
                </td>
            </tr>
            <tr>
                <td colspan="12"><form:input path="description" required="required"/></td>
            </tr>
            <tr>
                <td colspan="12" style="font-weight: bold">Địa chỉ liên lạc</td>
            </tr>
            <tr>
                <td colspan="4">Tỉnh/thành<span class="dot">(*)</span></td>
                <td colspan="4">Quận/huyện<span class="dot">(*)</span></td>
                <td colspan="4">Phường/xã<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <td colspan="4">
                    <form:select id="tp" path="city" onchange="getcbChild();" required="required">
                        <form:option value="" label="--- Chọn ---"/>
                        <form:option value="danang" label="Đà Nẵng"/>
                        <form:option value="hcm" label="Hồ Chí Minh"/>
                    </form:select>
                </td>
                <td colspan="4">
                    <form:select id="comboChild" path="district" onchange="getcbChild2();" required="required">
                        <form:option value="" label="--- Chọn ---"/>

                    </form:select>
                </td>
                <td colspan="4">
                    <form:select id="ward" path="ward">
                        <form:option value="" label="--- Chọn ---"/>

                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="12">Địa chỉ nơi ở<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <td colspan="12">
                    <form:input path="currentAddress" required="required"/>
                </td>
            </tr>
            <tr>
                <td colspan="6">Điện thoại<span class="dot">(*)</span></td>
                <td colspan="6">Email<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <td colspan="6"><form:input path="phone" required="required"/></td>
                <td colspan="6"><form:input path="email" required="required"/></td>
            </tr>
        </table>
        <table class="styleTable1">
            <tr>

                <td colspan="12" style="font-weight: bold; border: none">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <th class="styleTh" colspan="4">Triệu chứng</th>
                <th colspan="1">Có</th>
                <th colspan="1">Không</th>
                <th class="styleTh" colspan="4">Triệu chứng</th>
                <th colspan="1">Có</th>
                <th colspan="1">Không</th>
            </tr>
            <tr>
                <td colspan="4">Sốt<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[1]" value="Sot - true" required="required"/></td>
                <td colspan="1"><form:radiobutton path="symptoms[1]" value="Sot - false"/></td>
                <td colspan="4">Nôn/buồn nôn<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[2]" value="Non/buon non - true"/></td>
                <td colspan="1"><form:radiobutton path="symptoms[2]" value="Non/buon non - false"/></td>
            </tr>
            <tr>
                <td colspan="4">Ho<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[3]" value="Ho - true"/></td>
                <td colspan="1"><form:radiobutton path="symptoms[3]" value="Ho - false"/></td>
                <td colspan="4">Tiêu chảy<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[4]" value="Tieu Chay - true"  cssStyle="width: auto"/></td>
                <td colspan="1"><form:radiobutton path="symptoms[4]" value="Tieu Chay - false"/></td>
            </tr>
            <tr>
                <td colspan="4">Khó thở<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[5]" value="Kho tho - true"/></td>
                <td colspan="1"><form:radiobutton path="symptoms[5]" value="Kho tho - false"/></td>
                <td colspan="4">Xuất huyết ngoài da<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[6]" value="Xuat huyet ngoai da - true"/></td>
                <td colspan="1"><form:radiobutton path="symptoms[6]" value="Xuat huyet ngoai da - false"/></td>
            </tr>
            <tr>
                <td colspan="4">Đau họng<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[7]" value="Dau hong - true"  /></td>
                <td colspan="1"><form:radiobutton path="symptoms[7]" value="Dau hong - false" /></td>
                <td colspan="4">Nổi ban ngoài da<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="symptoms[8]" value="Noi ban ngoai da - true"/></td>
                <td colspan="1"><form:radiobutton path="symptoms[8]" value="Noi ban ngoai da - false"/></td>
            </tr>
        </table>
        <br>
        <table class="styleTable1">
            <tr>
                <td colspan="12" style="border: none; font-weight: bold"> Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có<span class="dot">(*)</span></td>
            </tr>
            <tr>
                <th colspan="10"> </th>
                <th colspan="1">Có</th>
                <th colspan="1">Không</th>
            </tr>
            <tr>
                <td colspan="10">Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ cơ sở giết mổ động vật/ tiếp xúc động vật<span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="exposureHistory[1]" value="exposureHistory1 - true"  /></td>
                <td colspan="1"><form:radiobutton path="exposureHistory[1]" value="exposureHistory1 - false" /></td>
            </tr>
            <tr>
                <td colspan="10">Tiếp xúc gần (<2m) với người mắc bệnh viên đường hô hấp do nCoV <span class="dot">(*)</span></td>
                <td colspan="1"><form:radiobutton path="exposureHistory[2]" value="exposureHistory2 - true"  /></td>
                <td colspan="1"><form:radiobutton path="exposureHistory[2]" value="exposureHistory2 - false" /></td>
            </tr>
         
        </table>
        <input type="submit" value="Submit"/>
    </form:form>
</div>

<script>
    getcbChild();// mỗi lần Form load thì cho nó chạy cái này để khi đảo lộn vị trí của thằng thành phố thì nó vẫn chạy đúng.
    function getcbChild() {
        var getValue = document.getElementById("tp").value;
        if (getValue == "danang") {
            document.getElementById("comboChild").innerHTML = '<select name="quanhuyen" required>'
                + '<option value="">--- Chọn ---</option>'
                + '<option value="Hải Châu">Hải Châu</option>'
                + '<option value="Cẩm Lệ">Cẩm Lệ</option>'
                + '<option value="Thanh Khê">Thanh Khê</option>'
                + '<option value="Liên Chiểu">Liên Chiểu</option>'
                + '<option value="Ngũ Hành Sơn">Ngũ Hành Sơn</option>'
                + '<option value="Sơn Trà">Sơn Trà</option>'
                + '</select>';
        } else if (getValue == "hcm") {
            document.getElementById("comboChild").innerHTML = '<select name="quanhuyen" required>'
                + '<option value="">--- Chọn ---</option>'
                + '<option value="Quận 1">Quận 1</option>'
                + '<option value="Quận 2">Quận 2</option>'
                + '<option value="Quận 3">Quận 3</option>'
                + '<option value="Quận 4">Quận 4</option>'
                + '<option value="Quận 5">Quận 5</option>'
                + '<option value="Quận 6">Quận 6</option></select>';
        }

    }

    function getcbChild2() {
        var getValue = document.getElementById("comboChild").value;
        if (getValue == "Hải Châu") {
            document.getElementById("ward").innerHTML = '<select name="quanhuyen" required>'
                + '<option value="Hải Châu">Hòa Cường Nam</option>'
                + '<option value="Cẩm Lệ">Hòa Cường Bắc</option>'
                + '</select>';
        } else if (getValue == "Cẩm Lệ") {
            document.getElementById("ward").innerHTML = '<select name="quanhuyen" required>'
                + '<option value="Hòa Thọ Đông">Hòa Thọ Đông</option>'
                + '<option value="Hòa Thọ Tây">Hòa Thọ Tây</option>' +
                '</select>';
        } else if (getValue == "Quận 1") {
            document.getElementById("ward").innerHTML = '<select name="quanhuyen" required>'
                + '<option value="Phạm Ngũ Lão">Phạm Ngũ Lão</option>'
                + '<option value="Tân Định">Tân Định</option>' +
                '</select>';
        }
    }
</script>
</body>
</html>
