<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <section class="page-hero">
            <div class="page-hero-bg"
                style="background-image:url('https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1920&q=80');">
            </div>
            <div class="page-hero-overlay"></div>
            <div class="page-hero-content">
                <p class="page-hero-eyebrow">&#9670; Viễn thám ký &#9670;</p>
                <h1 class="page-hero-title">Tin tức</h1>
                <p class="page-hero-subtitle">Cập nhật tình hình từ tiền tuyến khai phá. Đại nghiệp diễn tiến. Hắc ám
                    diên miên.</p>
            </div>
        </section>

        <!-- FEATURED POST -->
        <section class="section section-dark">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Tinh Tuyển</span>
                    <h2 class="section-title">Tối Tân Thư Tín</h2>
                    <div class="section-divider"></div>
                </div>

                <div class="news-grid">
                    <div class="news-card-featured">
                        <img class="news-featured-img"
                            src="https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=900&q=80"
                            alt="Featured News" loading="lazy">
                        <div
                            style="padding:2.5rem; display:flex; flex-direction:column; justify-content:center; background:var(--dark-card);">
                            <span class="news-category">&#9670; ĐẠI CẬP NHẬT</span>
                            <span class="news-date">November 14, 2024</span>
                            <h2
                                style="font-family:'Cormorant Garamond',serif; font-size:1.8rem; color:var(--cream); margin-bottom:1rem; line-height:1.3;">
                                Phiên Bản 3.0: Đại Bản Mở Rộng — Trầm Luân Chi Thành
                            </h2>
                            <p class="font-crimson"
                                style="color:var(--mid-grey); font-size:1rem; line-height:1.7; margin-bottom:1.5rem;">
                                Bản cập nhật nội dung vĩ đại nhất lịch sử "Veil of Perdition" chính thức khởi tranh
                                trong tháng này.
                                Khai mở nhị đại địa lao khu vực, tứ đại chức nghiệp tân binh, thập tứ đại thủ lĩnh ác
                                chiến,
                                cùng sự cải tổ toàn diện đối với thần mộc thăng tiến của thôn trang. Sau 18 tháng ròng
                                rã kiến tạo,
                                hắc ám lại càng trầm luân.
                            </p>
                            <div style="display:flex; gap:1rem;">
                                <a href="#" class="btn btn-primary" style="font-size:0.68rem;">Đọc tiếp</a>
                                <a href="#" class="btn btn-secondary" style="font-size:0.68rem;">Ghi chú bản cập
                                    nhật</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- NEWS GRID -->
        <section class="section section-surface">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Tất cả các bản tin</span>
                    <h2 class="section-title">Tin tức gần đây</h2>
                    <div class="section-divider"></div>
                </div>

                <!-- Filter Tabs -->
                <div style="display:flex; gap:0.5rem; margin-bottom:2.5rem; flex-wrap:wrap;">
                    <a href="#" class="btn btn-primary" style="font-size:0.62rem; padding:0.4rem 1rem;">Tất cả</a>
                    <a href="#" class="btn btn-secondary" style="font-size:0.62rem; padding:0.4rem 1rem;">Cập nhật</a>
                    <a href="#" class="btn btn-secondary" style="font-size:0.62rem; padding:0.4rem 1rem;">Blog phát
                        triển</a>
                    <a href="#" class="btn btn-secondary" style="font-size:0.62rem; padding:0.4rem 1rem;">Cộng đồng</a>
                    <a href="#" class="btn btn-secondary" style="font-size:0.62rem; padding:0.4rem 1rem;">DLC</a>
                </div>

                <div class="grid-3">

                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1476231682828-37e571bc172f?w=600&q=80" alt="Balance"
                            loading="lazy">

                        <div class="card-body">
                            <span class="news-category">Cập Nhật Cân Bằng</span>
                            <span class="news-date">28 Thg 10, 2024</span>

                            <h3 class="card-title mt-1">2.9.3 — Cân Bằng Trong Bóng Tối</h3>

                            <p class="card-text">
                                Khả năng hồi phục căng thẳng của Crusader đã được tăng cường.
                                Trận chiến với Hag được chỉnh sửa để loại bỏ cơ chế hạ gục tức thì từng gây nhiều tranh
                                cãi trong cộng đồng.
                                Ghi chú cập nhật đầy đủ bên trong.
                            </p>
                        </div>

                        <div class="card-footer">
                            <span></span>
                            <a href="#" class="text-crimson font-Cormorant Garamond" style="font-size:0.62rem;">
                                Đọc thêm &#8594;
                            </a>
                        </div>
                    </div>

                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=600&q=80" alt="Dev Blog"
                            loading="lazy">

                        <div class="card-body">
                            <span class="news-category">Nhật Ký Phát Triển</span>
                            <span class="news-date">15 Thg 10, 2024</span>

                            <h3 class="card-title mt-1">Thiết Kế Darkest Dungeon: Triết Lý Boss</h3>

                            <p class="card-text">
                                Góc nhìn chuyên sâu về cách chúng tôi xây dựng các trận đánh boss —
                                sự cân bằng giữa độ khó, tính công bằng,
                                và cảm giác tuyệt vọng xứng đáng mà trò chơi muốn mang lại.
                            </p>
                        </div>

                        <div class="card-footer">
                            <span></span>
                            <a href="#" class="text-crimson font-Cormorant Garamond" style="font-size:0.62rem;">
                                Đọc thêm &#8594;
                            </a>
                        </div>
                    </div>

                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1475738198235-5e1f7f8d8395?w=600&q=80"
                            alt="Community" loading="lazy">

                        <div class="card-body">
                            <span class="news-category">Cộng Đồng</span>
                            <span class="news-date">3 Thg 10, 2024</span>

                            <h3 class="card-title mt-1">Triển Lãm Fan Art: Tháng 10 / 2024</h3>

                            <p class="card-text">
                                Hai mươi tám tác phẩm từ những nghệ sĩ tài năng nhất của cộng đồng.
                                Từ chân dung phong cách sơn dầu cho đến hầm ngục pixel art —
                                tháng này thật sự phi thường.
                            </p>
                        </div>

                        <div class="card-footer">
                            <span></span>
                            <a href="#" class="text-crimson font-Cormorant Garamond" style="font-size:0.62rem;">
                                Đọc thêm &#8594;
                            </a>
                        </div>
                    </div>

                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=600&q=80" alt="DLC"
                            loading="lazy">

                        <div class="card-body">
                            <span class="news-category">Công Bố DLC</span>
                            <span class="news-date">20 Thg 9, 2024</span>

                            <h3 class="card-title mt-1">The Sunken City: Cái Nhìn Đầu Tiên</h3>

                            <p class="card-text">
                                Những hình ảnh đầu tiên cùng concept art của bản mở rộng sắp tới.
                                Khu vực mới: Drowned Archives.
                                Class mới: The Diver.
                                Nỗi kinh hoàng mới: chưa được đặt tên.
                            </p>
                        </div>

                        <div class="card-footer">
                            <span></span>
                            <a href="#" class="text-crimson font-Cormorant Garamond" style="font-size:0.62rem;">
                                Đọc thêm &#8594;
                            </a>
                        </div>
                    </div>

                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1534447677768-be436bb09401?w=600&q=80"
                            alt="Accessibility" loading="lazy">

                        <div class="card-body">
                            <span class="news-category">Khả Năng Tiếp Cận</span>
                            <span class="news-date">8 Thg 9, 2024</span>

                            <h3 class="card-title mt-1">Tùy Chọn Hỗ Trợ Mới Trong 2.9</h3>

                            <p class="card-text">
                                Mở rộng chế độ hỗ trợ mù màu, điều chỉnh tốc độ chiến đấu,
                                thay đổi kích thước chữ,
                                và chế độ không áp lực giúp giữ nguyên cốt truyện mà không có permadeath.
                            </p>
                        </div>

                        <div class="card-footer">
                            <span></span>
                            <a href="#" class="text-crimson font-Cormorant Garamond" style="font-size:0.62rem;">
                                Đọc thêm &#8594;
                            </a>
                        </div>
                    </div>

                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1476231682828-37e571bc172f?w=600&q=80" alt="Console"
                            loading="lazy">

                        <div class="card-body">
                            <span class="news-category">Nền Tảng</span>
                            <span class="news-date">25 Thg 8, 2024</span>

                            <h3 class="card-title mt-1">Phiên Bản Console Đã Hoàn Thiện Nội Dung</h3>

                            <p class="card-text">
                                Phiên bản console của Veil of Perdition giờ đây đã bao gồm toàn bộ nội dung trên PC,
                                bao gồm cả hai bản mở rộng DLC.
                                Bóng tối giờ đã lan sang mọi nền tảng.
                            </p>
                        </div>

                        <div class="card-footer">
                            <span></span>
                            <a href="#" class="text-crimson font-Cormorant Garamond" style="font-size:0.62rem;">
                                Đọc thêm &#8594;
                            </a>
                        </div>
                    </div>

                </div>
            </div>
        </section>

        <!-- NEWSLETTER -->
        <section
            style="background:var(--dark-card); border-top:1px solid var(--border-dark); border-bottom:1px solid var(--border-dark); padding:4rem 2rem; text-align:center;">

            <div class="container-sm">

                <span class="section-eyebrow">Đừng Bỏ Lỡ Bất Kỳ Tin Tức Nào</span>

                <h2 class="section-title">Luôn Nắm Bắt Mọi Diễn Biến</h2>

                <p class="font-im-fell"
                    style="font-size:1.05rem; color:var(--mid-grey); margin-bottom:2rem; line-height:1.7;">

                    Bóng tối cũng mang theo những thông điệp của riêng nó.
                    Đăng ký để nhận các bản cập nhật lớn, ghi chú vá lỗi,
                    và những nội dung nổi bật từ cộng đồng trực tiếp gửi đến ngươi.
                </p>

                <form style="display:flex; gap:0.8rem; max-width:440px; margin:0 auto;" onsubmit="return false;">

                    <input type="email" placeholder="diachi@vungdat.com"
                        style="flex:1; padding:0.75rem 1rem; background:rgba(8,6,4,0.8); border:1px solid var(--border-mid); color:var(--cream); font-family:'Crimson Text',serif; font-size:1rem; outline:none;">

                    <button type="submit" class="btn btn-primary" style="white-space:nowrap; font-size:0.68rem;">
                        Đăng Ký
                    </button>

                </form>

            </div>
        </section>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>