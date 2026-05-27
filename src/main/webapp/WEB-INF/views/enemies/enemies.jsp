<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <section class="page-hero">
            <div class="page-hero-bg"
                style="background-image:url('https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=1920&q=80');">
            </div>
            <div class="page-hero-overlay"></div>
            <div class="page-hero-content">
                <p class="page-hero-eyebrow">&#9670; Sinh Vật Trong Bóng Tố &#9670;</p>
                <h1 class="page-hero-title">Quái vật</h1>
                <p class="page-hero-subtitle">Chúng không hận bạn, cũng chẳng sợ bạn. Chúng chỉ đơn giản là tàn sát và
                    ngấu nghiến — từ thể xác, lý trí, cho đến cả sợi hy vọng mong manh nhất.</p>
            </div>
        </section>

        <!-- ENEMY TYPE INTRO -->
        <section style="background:var(--dark-surface); padding:3rem 2rem;">
            <div class="container">
                <div style="display:grid; grid-template-columns:repeat(5,1fr); gap:1px; background:var(--border-dark);">
                    <div style="background:var(--dark-bg); padding:1.5rem 1rem; text-align:center;">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#9760;</span>
                        <span class="font-Cormorant Garamond"
                            style="font-size:0.6rem; letter-spacing:0.2em; text-transform:uppercase; color:var(--light-grey);">Thây
                            Ma</span>
                    </div>
                    <div style="background:var(--dark-bg); padding:1.5rem 1rem; text-align:center;">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#128027;</span>
                        <span class="font-Cormorant Garamond"
                            style="font-size:0.6rem; letter-spacing:0.2em; text-transform:uppercase; color:var(--light-grey);">Quái
                            Dị</span>
                    </div>
                    <div style="background:var(--dark-bg); padding:1.5rem 1rem; text-align:center;">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#128032;</span>
                        <span class="font-Cormorant Garamond"
                            style="font-size:0.6rem; letter-spacing:0.2em; text-transform:uppercase; color:var(--light-grey);">Dã
                            Thú</span>
                    </div>
                    <div style="background:var(--dark-bg); padding:1.5rem 1rem; text-align:center;">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#9820;</span>
                        <span class="font-Cormorant Garamond"
                            style="font-size:0.6rem; letter-spacing:0.2em; text-transform:uppercase; color:var(--light-grey);">Kẻ
                            Hút Máu</span>
                    </div>
                    <div style="background:var(--dark-bg); padding:1.5rem 1rem; text-align:center;">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#128008;</span>
                        <span class="font-Cormorant Garamond"
                            style="font-size:0.6rem; letter-spacing:0.2em; text-transform:uppercase; color:var(--light-grey);">Đạo
                            Tặc</span>
                    </div>
                </div>
            </div>
        </section>

        <!-- ENEMIES GRID -->
        <section class="section section-dark">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Danh Sách Quái Vật</span>
                    <h2 class="section-title">Thông tin quái vật</h2>
                    <div class="section-divider"></div>
                </div>
                <div class="grid-3">

                    <div class="enemy-card">
                        <span class="enemy-icon">&#9760;</span>
                        <span class="enemy-type">Thây Ma — Đồi Mộ</span>
                        <h3 class="enemy-name">Đám Xương Lang Thang</h3>
                        <p class="enemy-desc">
                            Tàn tích sống dậy của những kẻ từng phục vụ vùng lãnh địa này.
                            Vô thức, vô tận, và hoàn toàn không biết đến lòng thương xót.
                            Số lượng áp đảo chính là vũ khí nguy hiểm nhất của chúng.
                        </p>
                        <span class="enemy-threat threat-low">&#9670; MỐI ĐE DỌA THẤP</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#128027;</span>
                        <span class="enemy-type">Quái Dị — Darkest Dungeon</span>
                        <h3 class="enemy-name">Kẻ Xáo Trộn Hư Không</h3>
                        <p class="enemy-desc">
                            Một sinh vật thuần túy của vực không, được triệu hồi từ những nghi thức cấm kỵ.
                            Nó tồn tại chỉ để xóa bỏ mọi thứ.
                            Bất kỳ ai nhìn thẳng vào nó đều sẽ vĩnh viễn mất đi một phần lý trí.
                        </p>
                        <span class="enemy-threat threat-extreme">&#9670; MỐI ĐE DỌA CỰC ĐẠI</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#128032;</span>
                        <span class="enemy-type">Dã Thú — Weald</span>
                        <h3 class="enemy-name">Người Sói</h3>
                        <p class="enemy-desc">
                            Từng là con người — giờ chỉ còn lại chút ít.
                            Lời nguyền đã ăn sâu vào máu thịt nó.
                            Tiếng tru gây áp lực tinh thần lên cả tổ đội.
                            Móng vuốt của nó sẽ lo phần còn lại.
                        </p>
                        <span class="enemy-threat threat-high">&#9670; MỐI ĐE DỌA CAO</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#128025;</span>
                        <span class="enemy-type">Kẻ Hút Máu — Crimson Court</span>
                        <h3 class="enemy-name">Đao Phủ Huyết Giáo</h3>
                        <p class="enemy-desc">
                            Một thành viên méo mó của Crimson Court đã uống quá sâu thứ máu bị nguyền rủa.
                            Kháng cự hầu hết các loại sát thương.
                            Chỉ một lần tiếp xúc cũng đủ truyền Crimson Curse cho cả tổ đội.
                        </p>
                        <span class="enemy-threat threat-high">&#9670; MỐI ĐE DỌA CAO</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#128048;</span>
                        <span class="enemy-type">Dã Thú — Warrens</span>
                        <h3 class="enemy-name">Thần Heo</h3>
                        <p class="enemy-desc">
                            Dị thể cổ xưa được lũ người-heo ở Warrens tôn thờ.
                            Thực thể cấp Boss.
                            Kích thước khổng lồ của nó khiến những đòn đánh vào hàng sau gần như vô dụng.
                        </p>
                        <span class="enemy-threat threat-extreme">&#9670; MỐI ĐE DỌA CỰC ĐẠI</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#9889;</span>
                        <span class="enemy-type">Quái Dị — Cove</span>
                        <h3 class="enemy-name">Chúa Sao Sâu Thẳm</h3>
                        <p class="enemy-desc">
                            Nó trôi dạt từ đáy đại dương đen tối bên ngoài lãnh địa.
                            Và mang theo cả vực không cùng nó.
                            Chỉ nhìn nó quá lâu cũng đủ khiến tâm trí lập tức sụp đổ.
                        </p>
                        <span class="enemy-threat threat-extreme">&#9670; MỐI ĐE DỌA CỰC ĐẠI</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#128122;</span>
                        <span class="enemy-type">Thây Ma — Đồi Mộ</span>
                        <h3 class="enemy-name">Thủy Thủ Chìm Xác</h3>
                        <p class="enemy-desc">
                            Những thủy thủ bỏ mạng trong các hầm mộ ngập nước bên dưới lãnh địa.
                            Chúng vẫn mang theo những vũ khí cổ xưa đủ sắc bén để kết liễu một mạng người.
                            Không thể thương lượng với chúng.
                            Và thật ra, chưa bao giờ có thể.
                        </p>
                        <span class="enemy-threat threat-medium">&#9670; MỐI ĐE DỌA TRUNG BÌNH</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#127981;</span>
                        <span class="enemy-type">Đạo Tặc — Weald</span>
                        <h3 class="enemy-name">Xạ Thủ Lữ Đoàn</h3>
                        <p class="enemy-desc">
                            Những tên tội phạm được thuê tới để cướp bóc vùng lãnh địa đổ nát.
                            Nhưng thứ chúng tìm thấy lại là sự điên loạn.
                            Giờ đây, chúng canh giữ những hành lang này chẳng khác gì lũ quái vật thật sự.
                        </p>
                        <span class="enemy-threat threat-medium">&#9670; MỐI ĐE DỌA TRUNG BÌNH</span>
                    </div>

                    <div class="enemy-card">
                        <span class="enemy-icon">&#128013;</span>
                        <span class="enemy-type">Quái Dị — Darkest Dungeon</span>
                        <h3 class="enemy-name">Kẻ Sưu Tầm</h3>
                        <p class="enemy-desc">
                            Một thực thể lang thang đã thu thập đầu của những anh hùng đã ngã xuống
                            rồi tiếp tục điều khiển họ — bất tử, trống rỗng, chống lại chính đồng đội cũ.
                            Nó vẫn nhớ điểm yếu của họ.
                        </p>
                        <span class="enemy-threat threat-extreme">&#9670; MỐI ĐE DỌA CỰC ĐẠI</span>
                    </div>

                </div>
            </div>
        </section>

        <!-- BOSSES SECTION -->
<section class="section section-surface">
    <div class="container">

        <div class="section-header">
            <span class="section-eyebrow">Điểm Cuối Của Hành Trình</span>
            <h2 class="section-title">Trùm Hầm Ngục</h2>
            <p class="section-subtitle">
                Mỗi hầm ngục đều cất giấu một thực thể sở hữu sức mạnh khủng khiếp.
                Chúng không phải chướng ngại vật.
                Chúng là hậu quả.
            </p>
            <div class="section-divider"></div>
        </div>

        <div class="grid-2">

            <div class="split-section" style="padding:2rem 0;">
                <div class="split-img-wrapper">
                    <img src="https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=600&q=80"
                        alt="Necromancer Lord" loading="lazy">
                </div>

                <div class="split-text">
                    <div class="split-tag">Boss Khu Tàn Tích</div>
                    <h3 class="split-title">Chúa Tể Triệu Hồn</h3>
                    <div class="split-divider"></div>

                    <p class="split-body">
                        Hắn từng là học trò trung thành nhất của Tổ Tiên.
                        Giờ đây, hắn cai trị khu Tàn Tích bằng ma thuật tử linh và lòng hận thù vô tận.
                        Trong chiến đấu, hắn có thể hồi sinh chính thuộc hạ của mình.
                    </p>

                    <span class="enemy-threat threat-extreme" style="display:inline-block;">
                        &#9670; MỐI ĐE DỌA CỰC ĐẠI
                    </span>
                </div>
            </div>

            <div class="split-section" style="padding:2rem 0;">
                <div class="split-img-wrapper">
                    <img src="https://images.unsplash.com/photo-1476231682828-37e571bc172f?w=600&q=80"
                        alt="Hag" loading="lazy">
                </div>

                <div class="split-text">
                    <div class="split-tag">Boss Khu Rừng Weald</div>
                    <h3 class="split-title">Mụ Phù Thủy</h3>
                    <div class="split-divider"></div>

                    <p class="split-body">
                        Một sinh vật cổ xưa tồn tại trước cả vùng lãnh địa này.
                        Mụ nhét các anh hùng vào chiếc vạc khổng lồ của mình —
                        loại họ hoàn toàn khỏi trận chiến trong khi thiêu sống họ bên trong.
                    </p>

                    <span class="enemy-threat threat-extreme" style="display:inline-block;">
                        &#9670; MỐI ĐE DỌA CỰC ĐẠI
                    </span>
                </div>
            </div>

        </div>
    </div>
</section>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>