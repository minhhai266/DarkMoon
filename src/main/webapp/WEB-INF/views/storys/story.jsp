<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <!-- PAGE HERO -->
        <section class="page-hero">
            <div class="page-hero-bg"
                style="background-image:url('${pageContext.request.contextPath}/img/aa.png');">
            </div>
            <div class="page-hero-overlay"></div>
            <div class="page-hero-content">
                <p class="page-hero-eyebrow">&#9670; Truyền kỳ &#9670;</p>
                <h1 class="page-hero-title">Cốt truyện</h1>
                <p class="page-hero-subtitle">Một giai thoại về sự ngạo mạn, hủ bại, và bóng tối đang rập rình những kẻ
                    mưu cầu cấm lực.</p>
            </div>
        </section>

        <!-- ACT I -->
        <c:forEach items="${stories}" var="story" varStatus="status">
            <section class="section ${status.index % 2 == 0 ? 'section-dark' : 'section-darker'}">
                <div class="container">
                    <div class="split-section ${status.index % 2 != 0 ? 'reverse' : ''}">
                        <div class="split-img-wrapper">
                            <img src="${story.image}"
                                alt="${story.title}"
                                loading="lazy">
                        </div>
                        <div class="split-text">
                            <div class="split-tag">
                                ${story.tag}
                            </div>
                            <h2 class="split-title">
                                ${story.title}
                            </h2>
                            <div class="split-divider"></div>
                            <p class="split-body">
                                ${story.content}
                            </p>
                        </div>
                    </div>
                </div>
            </section>
            <c:if test="${not empty story.quoteContent}">
                <section style="background:var(--dark-surface); padding:4rem 2rem;">
                    <div class="container-sm">
                        <div class="quote-block">
                            <p class="quote-text">
                                ${story.quoteContent}
                            </p>
                            <c:if test="${not empty story.quoteAuthor}">
                                <span class="quote-author">
                                    — ${story.quoteAuthor}
                                </span>
                            </c:if>
                        </div>
                    </div>
                </section>
            </c:if>
        </c:forEach>

        <!-- ACT III TEASER
        <section class="section section-dark">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Khải huyền</span>
                    <h2 class="section-title">Chương I — Minh cảnh chi tâm</h2>
                    <div class="section-divider"></div>
                    <p class="section-subtitle">chưa có y tưởng<br>It is a truth your ancestor spent his life trying to
                        reach.</p>
                </div>
                <div class="grid-3" style="margin-top:3rem;">
                    <div class="card" style="text-align:center; padding:2rem;">
                        <div style="font-size:2.5rem; margin-bottom:1rem;">&#9760;</div>
                        <h3 class="card-title mb-2">Tinh Thần Là Một Tài Nguyên</h3>
                        <p class="card-text"> Áp lực sẽ dần tích tụ. Các anh hùng rồi sẽ gục ngã.
                            Những chứng loạn tâm bóp méo hành động của họ trong chiến đấu.
                            Hãy quản lý tâm trí cẩn thận như chính cơ thể.</p>
                    </div>
                    <div class="card" style="text-align:center; padding:2rem;">
                        <div style="font-size:2.5rem; margin-bottom:1rem;">&#128161;</div>
                        <h3 class="card-title mb-2">Bóng Tối Không Ngừng Biến Đổi</h3>
                        <p class="card-text">
                            Không có hai chuyến thám hiểm nào giống nhau.
                            Hầm ngục biết thở. Nó thích nghi.
                            Và nó luôn ghi nhớ.
                        </p>
                    </div>
                    <div class="card" style="text-align:center; padding:2rem;">
                        <div style="font-size:2.5rem; margin-bottom:1rem;">&#127981;</div>
                        <h3 class="card-title mb-2">Tinh Thần Là Một Tài Nguyên</h3>
                        <p class="card-text">
                            Áp lực sẽ dần tích tụ. Các anh hùng rồi sẽ gục ngã.
                            Những chứng loạn tâm bóp méo hành động của họ trong chiến đấu.
                            Hãy quản lý tâm trí cẩn thận như chính cơ thể.
                        </p>
                    </div>
                </div>
            </div>
        </section>

        
        <section class="section section-surface">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Những Mảnh Tàn Tích Được Khai Quật</span>
                    <h2 class="section-title">Truyền Thuyết Về Vùng Đất Bị Nguyền Rủa</h2>
                    <div class="section-divider"></div>
                </div>
                <div class="grid-2">
                    <div class="card" style="padding:1.8rem;">
                        <span class="card-tag">Kinh Thánh Cũ — Mảnh VII</span>
                        <h3 class="card-title mb-2">Hiệp Ước của Việc Làm</h3>
                        <p class="card-text" style="font-style:italic;">
                            "...và hắn đã cất lên những lời không nên được thốt ra,
                            còn mặt đất đáp lại bằng máu.
                            Giao ước ấy không được khắc bằng chữ ký,
                            mà bằng tiếng gào thét của hàng vạn linh hồn
                            bị kéo xuống bên dưới ranh giới của thế giới tỉnh thức..."
                        </p>
                    </div>
                    <div class="card" style="padding:1.8rem;">
                        <span class="card-tag">Tài Liệu Của Người Sống Sót — Chưa Biết Tên</span>
                        <h3 class="card-title mb-2">Những Gì Người Sống Sót Nói</h3>
                        <p class="card-text" style="font-style:italic;">
                            "Chúng tôi nghe thấy nó trước khi thấy nó—một âm thanh như thế giới đang quên tên mình.
                            Ba người trong nhóm của chúng tôi quay đầu chạy. Hai trong số ba người đó đã trở lại làng.
                            Người thứ ba cũng đã trở lại, nhưng anh ta không còn một mình nữa..."
                        </p>
                    </div>
                    <div class="card" style="padding:1.8rem;">
                        <span class="card-tag">Nhật Ký Của Tổ Tiên — Dòng Cuối Cùng</span>
                        <h3 class="card-title mb-2">Lời Thú Tội Quá Muộn</h3>
                        <p class="card-text" style="font-style:italic;">
                            "Ta từng tìm cách vượt lên khỏi cái chết.
                            Nhưng thứ ta vượt qua lại là lòng nhân từ.
                            Dù điều gì xảy đến tiếp theo —
                            với ta, với vùng đất này, hay với ngươi, kẻ đang đọc những dòng chữ này —
                            hãy biết rằng ta hối hận.
                            Và hãy biết rằng điều đó chẳng thay đổi được gì.
                            Ngươi phải hoàn thành thứ mà ta đã bắt đầu."
                        </p>
                    </div>
                    <div class="card" style="padding:1.8rem;">
                        <span class="card-tag">Ghi Chú Của Người Bản đồ</span>
                        <h3 class="card-title mb-2">Hầm Ngục Luôn Biến Đổi</h3>
                        <p class="card-text" style="font-style:italic;">
                            "Ta đã vẽ lại những hành lang này mười bảy lần.
                            Và mỗi lần, cấu trúc của chúng đều thay đổi.
                            Hầm ngục này không phải một nơi chốn.
                            Nó là một cơn đói.
                            Và nó chưa bao giờ ngừng đói khát.
                            Đừng tin vào ký ức của ngươi về con đường.
                            Hãy chỉ tin vào ngọn đuốc trong tay."
                        </p>
                    </div>
                </div>
            </div>
        </section> -->

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>