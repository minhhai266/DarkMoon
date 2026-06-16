<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <section class="page-hero">
            <div class="page-hero-bg"
                style="background-image:url('${pageContext.request.contextPath}/img/world-back.png');">
            </div>
            <div class="page-hero-overlay"></div>
            <div class="page-hero-content">
                <p class="page-hero-eyebrow">&#9670; Vùng Đất Bị Nguyền Rủa &#9670;</p>
                <h1 class="page-hero-title">Thế giới</h1>
                <p class="page-hero-subtitle">Mỗi góc tàn trang đều ẩn tàng một loại kinh hãi dị biệt.
                    Mỗi kinh hãi đều mang theo một bài học khác nhau.
                    Và ngươi sẽ phải lĩnh hội toàn bộ chúng.</p>
            </div>
        </section>
        <!-- WORLD OVERVIEW -->
        <section style="background:var(--dark-surface); padding:4rem 2rem;">
            <c:forEach items="${worlds}" var="world">
                <div class="container">
                    <div class="split-section">
                        <div class="split-text">
                            <div class="split-tag">
                                <c:out value="${world.tag}" />
                            </div>
                            <h2 class="split-title">
                                <c:out value="${world.title}" />
                            </h2>
                            <div class="split-divider"></div>
                            <p class="split-body">
                                <c:out value="${world.content}" />
                            </p>
                        </div>
                        <div class="split-img-wrapper">
                            <img src="${world.image}"
                                alt="${world.title}"
                                loading="lazy">
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>

   
        <!-- <section class="section section-dark">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Vùng đất</span>
                    <h2 class="section-title">Viện Nghiên Cứu Giả Kim</h2>
                    <div class="section-divider"></div>
                </div>
                <div class="grid-3">

                    <div class="location-card">
                        <div class="location-danger">
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                        </div>
                        <h3 style="font-family:'Cormorant Garamond',serif; color:var(--cream); margin-bottom:0.5rem;">
                            Phế Tích</h3>
                        <span class="enemy-type" style="display:block; margin-bottom:0.8rem;">Khuyến Nghị:
                            Học Đồ</span>
                        <p class="card-text">
                            Đại sảnh tổ đường của cổ trạch nay đã bị tử linh chiếm cứ.
                            Những hành lang thạch cổ cùng các hầm mộ ngập nước đan xen bên dưới vinh quang đã lụi tàn
                            thuở trước.
                            Tử Linh Quân Chủ đang ngự trị nơi đây.</p>
                        <div style="margin-top:1rem; padding-top:1rem; border-top:1px solid var(--border-dark);">
                            <span
                                style="font-family:'Cormorant Garamond',serif; font-size:0.6rem; letter-spacing:0.15em; text-transform:uppercase; color:var(--ash-grey);">Primary
                                Hiểm Họa: Bất Tử Giả, U Hồn</span>
                        </div>
                    </div>

                    <div class="location-card">
                        <div class="location-danger">
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                        </div>
                        <h3 style="font-family:'Cormorant Garamond',serif; color:var(--cream); margin-bottom:0.5rem;">
                            Hắc Lâm</h3>
                        <span class="enemy-type" style="display:block; margin-bottom:0.8rem;">Khuyến Nghị:
                            Veteran</span>
                        <p class="card-text">
                            Khu rừng này từng là ngự uyển được chăm sóc tỉ mỉ của cổ trạch.
                            Nhưng nay đã bị vặn vẹo đến mức không còn nhận ra nguyên dạng — ngay cả cây cối dường như
                            cũng đang dõi mắt quan sát kẻ lạc bước.
                            Đám đạo tặc đã dựng doanh trại nơi đây, song cũng dần phát cuồng bởi những thứ đang cùng tồn
                            tại với chúng trong khu hắc lâm này.
                        </p>
                        <div style="margin-top:1rem; padding-top:1rem; border-top:1px solid var(--border-dark);">
                            <span
                                style="font-family:'Cormorant Garamond',serif; font-size:0.6rem; letter-spacing:0.15em; text-transform:uppercase; color:var(--ash-grey);">Primary
                                Hiểm Họa: Động Vật, Đạo Tặc, Ma Nữ</span>
                        </div>
                    </div>

                    <div class="location-card">
                        <div class="location-danger">
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                        </div>
                        <h3 style="font-family:'Cormorant Garamond',serif; color:var(--cream); margin-bottom:0.5rem;">
                            U Ám Hào Khẩu
                        </h3>
                        <span class="enemy-type" style="display:block; margin-bottom:0.8rem;">Khuyến Nghị:
                            Veteran</span>
                        <p class="card-text">
                            Mê cung địa đạo được đào đục bởi lũ Trư Nhân sinh sôi trong bóng tối vô tận.
                            Những lối đi chật hẹp buộc kẻ tiến nhập phải thay đổi chiến thuật để sinh tồn.
                            Chỉ riêng mùi hôi thối nơi đây cũng đủ khiến tâm trí dần suy kiệt.
                            Ở tầng sâu nhất của hủ huyệt, Trư Thần đang lặng lẽ chờ đợi.
                        </p>
                        <div style="margin-top:1rem; padding-top:1rem; border-top:1px solid var(--border-dark);">
                            <span
                                style="font-family:'Cormorant Garamond',serif; font-size:0.6rem; letter-spacing:0.15em; text-transform:uppercase; color:var(--ash-grey);">Primary
                                Hiểm Họa: Lợn, Xác Sống</span>
                        </div>
                    </div>

                    <div class="location-card">
                        <div class="location-danger">
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull active">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                        </div>
                        <h3 style="font-family:'Cormorant Garamond',serif; color:var(--cream); margin-bottom:0.5rem;">
                            Hắc Thủy Vịnh</h3>
                        <span class="enemy-type" style="display:block; margin-bottom:0.8rem;">Khuyến Nghị:
                            Champion</span>
                        <p class="card-text">
                            Những hang động biển được xói mòn vào vách đá ven biển của khu đất này. Có thứ gì đó đã xuất
                            hiện từ đại dương sâu thẳm
                            và đã sống ở đây kể từ khi các thí nghiệm của Tổ Tiên bắt đầu. Nước tự thân nó dường như
                            sai lệch.
                        </p>
                        <div style="margin-top:1rem; padding-top:1rem; border-top:1px solid var(--border-dark);">
                            <span
                                style="font-family:'Cormorant Garamond',serif; font-size:0.6rem; letter-spacing:0.15em; text-transform:uppercase; color:var(--ash-grey);">Primary
                                Hiểm Họa: Elritch, Fishmen</span>
                        </div>
                    </div>

                    <div class="location-card"
                        style="border-color:var(--blood-red); box-shadow:0 0 30px rgba(139,0,0,0.2);">
                        <div class="location-danger">
                            <span class="danger-skull active"
                                style="color:#FF0000; filter:drop-shadow(0 0 6px red);">&#9760;</span>
                            <span class="danger-skull active"
                                style="color:#FF0000; filter:drop-shadow(0 0 6px red);">&#9760;</span>
                            <span class="danger-skull active"
                                style="color:#FF0000; filter:drop-shadow(0 0 6px red);">&#9760;</span>
                            <span class="danger-skull active"
                                style="color:#FF0000; filter:drop-shadow(0 0 6px red);">&#9760;</span>
                            <span class="danger-skull active"
                                style="color:#FF0000; filter:drop-shadow(0 0 6px red);">&#9760;</span>
                        </div>
                        <h3
                            style="font-family:'Cormorant Garamond',serif; color:var(--cream); margin-bottom:0.5rem; text-shadow:0 0 15px rgba(255,0,0,0.4);">
                            Hắc Ám Động</h3>
                        <span class="enemy-type"
                            style="display:block; margin-bottom:0.8rem; color:var(--crimson);">Khuyến Nghị: Chiến binh —
                            Chuẩn Bị Tối Đa</span>
                        <p class="card-text">
                            Khu vực cuối cùng. Lý do cho tất cả điều này. Ác quỷ cổ đại ở tim lòng của khu đất này, nơi
                            mà những thí nghiệm của Tổ Tiên đã mở ra một cánh cổng dẫn đến một chiều không gian khác —
                            một vương quốc của bóng tối và tuyệt vọng.
                            Tội nghiệt của tổ tiên vẫn còn tồn tại nơi đây.
                            Không thứ gì bước vào vùng đất này mà có thể rời đi trong nguyên dạng cũ — nếu còn có thể
                            rời đi.
                            Đây chính là tận điểm của mọi hành trình.
                        </p>
                        <div style="margin-top:1rem; padding-top:1rem; border-top:1px solid var(--border-dark);">
                            <span
                                style="font-family:'Cormorant Garamond',serif; font-size:0.6rem; letter-spacing:0.15em; text-transform:uppercase; color:var(--crimson);">Primary
                                Hiểm Họa: Tâm Hồn Tối Lâu</span>
                        </div>
                    </div>

                    <div class="location-card">
                        <div class="location-danger">
                            <span class="danger-skull active" style="color:var(--gold);">&#9760;</span>
                            <span class="danger-skull active" style="color:var(--gold);">&#9760;</span>
                            <span class="danger-skull active" style="color:var(--gold);">&#9760;</span>
                            <span class="danger-skull active" style="color:var(--gold);">&#9760;</span>
                            <span class="danger-skull">&#9760;</span>
                        </div>
                        <h3 style="font-family:'Cormorant Garamond',serif; color:var(--cream); margin-bottom:0.5rem;">
                            Đỏa Huyết Vương Đình</h3>
                        <span class="enemy-type" style="display:block; margin-bottom:0.8rem;">DLC — Champion
                            Level</span>
                        <p class="card-text">
                            Từng là thành tựu xã giao vĩ đại nhất của Tổ Tiên — một yến hội quy tụ những quý tộc khát
                            huyết đã tiếp nhận lời mời theo đúng nghĩa đen.
                            Giờ đây, chúng ám trú nơi thượng tầng của cổ trang viên, gieo rắc huyết chú lên bất kỳ kẻ lữ
                            hành ngu muội nào dám tiến nhập.
                        </p>
                        <div style="margin-top:1rem; padding-top:1rem; border-top:1px solid var(--border-dark);">
                            <span
                                style="font-family:'Cormorant Garamond',serif; font-size:0.6rem; letter-spacing:0.15em; text-transform:uppercase; color:var(--gold);">DLC
                                Content</span>
                        </div>
                    </div>

                </div>
            </div>
        </section> -->

        <!-- THE HAMLET -->
        <!-- <section class="section section-surface">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Your Base</span>
                    <h2 class="section-title">Hắc Thôn</h2>
                    <p class="section-subtitle">Pháo đài hy vọng cuối cùng còn sót lại.
                        Hãy đầu tư vào nó một cách khôn ngoan — bởi đây là thứ duy nhất còn đứng giữa những anh hùng của
                        ngươi và vực thẳm hư vô</p>
                    <div class="section-divider"></div>
                </div>
                <div class="grid-4">
                    <div class="card" style="padding:1.8rem; text-align:center;">
                        <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#9963;</span>
                        <h3 class="card-title mb-2">Dạ Ẩm Quán</h3>
                        <p class="card-text">Các anh hùng tìm đến tửu sắc, cờ bạc và truỵ lạc để giải tỏa áp lực đang
                            gặm nhấm tâm trí.
                            Đôi khi điều đó phát huy tác dụng.
                            Đôi khi, họ chỉ đổi lấy những ác tật mới còn hiểm độc hơn.
                        </p>
                    </div>
                    <div class="card" style="padding:1.8rem; text-align:center;">
                        <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#9770;</span>
                        <h3 class="card-title mb-2">The Abbey</h3>
                        <p class="card-text">Cầu nguyện, thiền định, và hành hạ bản thân giúp giảm stress cho những
                            người tín đồ.
                            Những anh hùng khác nhau phản ứng với các phương pháp điều trị khác nhau. Hãy học cách nhận
                            biết.</p>
                    </div>
                    <div class="card" style="padding:1.8rem; text-align:center;">
                        <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#9877;</span>
                        <h3 class="card-title mb-2">Giáo Đình Suy Vong</h3>
                        <p class="card-text">Thanh trừ dị tật cùng tâm chứng.
                            Cố định những phẩm tính hữu ích, đồng thời loại bỏ các lệch lạc tâm tính dẫn anh hùng đến tử
                            địa.
                            Cái giá phải trả vô cùng đắt đỏ — nhưng tuyệt đối thiết yếu.</p>
                    </div>
                    <div class="card" style="padding:1.8rem; text-align:center;">
                        <span style="font-size:2rem; display:block; margin-bottom:0.8rem;">&#9876;</span>
                        <h3 class="card-title mb-2">Thợ Rèn</h3>
                        <p class="card-text">Nâng cấp vũ khí và giáp trụ. Mỗi cấp độ nâng cấp đều biến một chiến binh
                            yếu đuối thành thứ có thể sống sót trước những điều đang chờ đợi phía dưới.</p>
                    </div>
                </div>
            </div>
        </section> -->

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>