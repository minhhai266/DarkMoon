<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<section class="page-hero">
    <div class="page-hero-bg"
        style="background-image:url('https://images.unsplash.com/photo-1599508704512-2f19efd1e35f?w=1920&q=80');"></div>
    <div class="page-hero-overlay"></div>

    <div class="page-hero-content">
        <p class="page-hero-eyebrow">&#9670; Nơi Nương Náu Cuối Cùng &#9670;</p>
        <h1 class="page-hero-title">Hỗ Trợ</h1>
        <p class="page-hero-subtitle">
            Chúng tôi không thể gửi anh hùng tới cứu ngươi.
            Nhưng chúng tôi có thể trả lời câu hỏi của ngươi.
        </p>
    </div>
</section>

<!-- SUPPORT QUICK LINKS -->
<section style="background:var(--dark-surface); padding:3rem 2rem;">
    <div class="container">

        <div class="grid-4">

            <div class="card" style="padding:1.8rem; text-align:center; cursor:pointer;">
                <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#9877;</span>

                <h3 class="card-title mb-2" style="font-size:0.9rem;">
                    Sự Cố Kỹ Thuật
                </h3>

                <p class="card-text" style="font-size:0.85rem;">
                    Crash game, hiệu năng, và các lỗi riêng theo từng nền tảng.
                </p>
            </div>

            <div class="card" style="padding:1.8rem; text-align:center; cursor:pointer;">
                <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#9820;</span>

                <h3 class="card-title mb-2" style="font-size:0.9rem;">
                    Tài Khoản &amp; Mua Hàng
                </h3>

                <p class="card-text" style="font-size:0.85rem;">
                    Thanh toán, hoàn tiền, và các vấn đề quản lý tài khoản.
                </p>
            </div>

            <div class="card" style="padding:1.8rem; text-align:center; cursor:pointer;">
                <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#128027;</span>

                <h3 class="card-title mb-2" style="font-size:0.9rem;">
                    Báo Cáo Lỗi
                </h3>

                <p class="card-text" style="font-size:0.85rem;">
                    Báo lỗi trong game, exploit, và các hành vi ngoài ý muốn.
                </p>
            </div>

            <div class="card" style="padding:1.8rem; text-align:center; cursor:pointer;">
                <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#9988;</span>

                <h3 class="card-title mb-2" style="font-size:0.9rem;">
                    Khả Năng Tiếp Cận
                </h3>

                <p class="card-text" style="font-size:0.85rem;">
                    Tùy chọn hỗ trợ tiếp cận, phản hồi, và yêu cầu hỗ trợ đặc biệt.
                </p>
            </div>

        </div>
    </div>
</section>

<!-- FAQ ACCORDION -->
<section class="section section-dark">
    <div class="container">

        <div class="split-section">

            <div>

                <div class="split-tag">FAQ</div>

                <h2 class="split-title" style="margin-bottom:1.5rem;">
                    Câu Hỏi Thường Gặp
                </h2>

                <div class="support-accordion">

                    <div class="accordion-item">

                        <div class="accordion-header">
                            <span class="accordion-question">
                                Có cách nào tắt permadeath không?
                            </span>

                            <span class="accordion-icon">+</span>
                        </div>

                        <div class="accordion-body">
                            <p class="accordion-answer">
                                Có.
                                Trong phiên bản 2.9, chúng tôi đã thêm chế độ
                                "Ngọn Lửa Hy Vọng", cho phép giữ lại tiến trình của anh hùng sau khi chết
                                thay vì xóa họ vĩnh viễn.
                                Chế độ này được hỗ trợ đầy đủ và không ảnh hưởng đến thành tựu.
                                Có thể bật hoặc tắt trong phần Cài Đặt bất kỳ lúc nào.
                            </p>
                        </div>

                    </div>

                    <div class="accordion-item">

                        <div class="accordion-header">
                            <span class="accordion-question">
                                Làm sao để sửa lỗi crash khi khởi động?
                            </span>

                            <span class="accordion-icon">+</span>
                        </div>

                        <div class="accordion-body">
                            <p class="accordion-answer">
                                Trước tiên, hãy kiểm tra tính toàn vẹn của file game
                                thông qua trình quản lý thư viện của nền tảng bạn sử dụng.
                                Nếu lỗi vẫn tiếp diễn, hãy cập nhật driver card đồ họa.
                                Với người chơi PC, hãy đảm bảo DirectX 12 đã được cài đặt.
                                Nếu vẫn chưa khắc phục được,
                                hãy liên hệ với chúng tôi qua biểu mẫu bên dưới
                                kèm cấu hình máy và crash log.
                            </p>
                        </div>

                    </div>

                    <div class="accordion-item">

                        <div class="accordion-header">
                            <span class="accordion-question">
                                Game có hỗ trợ cloud save không?
                            </span>

                            <span class="accordion-icon">+</span>
                        </div>

                        <div class="accordion-body">
                            <p class="accordion-answer">
                                Có.
                                Cloud save được hỗ trợ trên mọi nền tảng.
                                Dữ liệu sẽ tự động đồng bộ khi bạn thoát game.
                                Bạn cũng có thể đồng bộ thủ công từ menu chính.
                                Tính năng chuyển save giữa PC và Console hiện đang được phát triển
                                và dự kiến ra mắt trong Q1 2025.
                            </p>
                        </div>

                    </div>

                    <div class="accordion-item">

                        <div class="accordion-header">
                            <span class="accordion-question">
                                Tôi có thể mod game không?
                            </span>

                            <span class="accordion-icon">+</span>
                        </div>

                        <div class="accordion-body">
                            <p class="accordion-answer">
                                Phiên bản PC hỗ trợ mod hoàn toàn thông qua Steam Workshop.
                                Bộ công cụ mod chính thức được phát hành miễn phí,
                                bao gồm tài liệu hướng dẫn tạo hầm ngục, quái vật,
                                vật phẩm và class anh hùng mới.
                                Mod trên console hiện chưa được hỗ trợ,
                                nhưng đang được xem xét tích cực.
                            </p>
                        </div>

                    </div>

                    <div class="accordion-item">

                        <div class="accordion-header">
                            <span class="accordion-question">
                                Chính sách hoàn tiền như thế nào?
                            </span>

                            <span class="accordion-icon">+</span>
                        </div>

                        <div class="accordion-body">
                            <p class="accordion-answer">
                                Chính sách hoàn tiền sẽ phụ thuộc vào nền tảng bạn mua game
                                (Steam, Epic, PlayStation Store, v.v.).
                                Chúng tôi hỗ trợ toàn bộ quy trình hoàn tiền tiêu chuẩn của từng nền tảng.
                                Nếu bạn bị tính phí sai hoặc gặp lỗi thanh toán,
                                hãy liên hệ trực tiếp với chúng tôi qua biểu mẫu bên dưới.
                            </p>
                        </div>

                    </div>

                    <div class="accordion-item">

                        <div class="accordion-header">
                            <span class="accordion-question">
                                Game có các tùy chọn hỗ trợ tiếp cận không?
                            </span>

                            <span class="accordion-icon">+</span>
                        </div>

                        <div class="accordion-body">
                            <p class="accordion-answer">
                                Có.
                                Chúng tôi hỗ trợ nhiều chế độ mù màu
                                (deuteranopia, protanopia, tritanopia),
                                chỉnh kích thước chữ lên tới 200%,
                                điều chỉnh tốc độ chiến đấu,
                                và chế độ Ngọn Lửa Hy Vọng thay thế permadeath.
                                Chúng tôi vẫn đang phát triển thêm các tùy chọn mới dựa trên phản hồi cộng đồng.
                            </p>
                        </div>

                    </div>

                </div>
            </div>

            <!-- CONTACT FORM -->
            <div>

                <div class="split-tag">Liên Hệ Trực Tiếp</div>

                <h2 class="split-title" style="margin-bottom:1.5rem;">
                    Gửi Tin Nhắn
                </h2>

                <div class="contact-form">

                    <form id="contactForm">

                        <div class="form-group">
                            <label class="form-label" for="name">Tên Của Ngươi</label>

                            <input type="text"
                                id="name"
                                class="form-control"
                                placeholder="Nhập tên của ngươi"
                                required>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="email">Địa Chỉ Email</label>

                            <input type="email"
                                id="email"
                                class="form-control"
                                placeholder="email@vungdat.com"
                                required>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="category">Danh Mục</label>

                            <select id="category" class="form-control">
                                <option value="">Chọn danh mục...</option>
                                <option>Sự Cố Kỹ Thuật</option>
                                <option>Báo Cáo Lỗi</option>
                                <option>Tài Khoản / Mua Hàng</option>
                                <option>Khả Năng Tiếp Cận</option>
                                <option>Chương Trình Creator</option>
                                <option>Liên Hệ Báo Chí</option>
                                <option>Khác</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="platform">Nền Tảng</label>

                            <select id="platform" class="form-control">
                                <option value="">Chọn nền tảng...</option>
                                <option>PC (Steam)</option>
                                <option>PC (Epic Games)</option>
                                <option>PlayStation 5</option>
                                <option>Xbox Series X/S</option>
                                <option>Nintendo Switch</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="form-label" for="message">Tin Nhắn</label>

                            <textarea id="message"
                                class="form-control"
                                placeholder="Hãy mô tả vấn đề của ngươi càng chi tiết càng tốt. Bóng tối luôn đủ kiên nhẫn để chờ đợi."></textarea>
                        </div>

                        <button type="submit"
                            class="btn btn-primary w-full"
                            style="justify-content:center;">

                            &#9670; Gửi Vào Vực Thẳm
                        </button>

                    </form>

                </div>
            </div>

        </div>
    </div>
</section>