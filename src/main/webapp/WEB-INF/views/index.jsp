<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <!-- HERO -->
        <section class="hero">
            <div class="hero-bg" style="background-image:url('${pageContext.request.contextPath}/img/back.png');">
            </div>
            <div class="hero-overlay"></div>
            <div class="hero-vignette"></div>

            <!-- ============================================================
                                    HOME PAGE
        ============================================================= -->
            <div class="hero-content">
                <div>
                    <div class="hero-eyebrow">Dark Fantasy RPG</div>
                    <h1 class="hero-title">MOON BLIGHT</h1>
                    <p class="hero-title-sub">Chìm vào thế giới hư vô bị nguyền rủa</p>
                    <div class="hero-divider"></div>
                    <p class="hero-desc">
                        Thiên hạ đã diệt vong. Tà lực cổ xưa đang thống trị cõi trần.
                        Ngươi phải hiệu triệu một đoàn tàn hồn và tiến nhập hắc ám —
                        nơi thần trí còn hiếm quý hơn kim ngân, và từ bi là xa xỉ phẩm mà ngươi không thể lưu giữ.
                    </p>
                    <div class="hero-buttons">
                        <a href="/story" class="btn btn-secondary btn-primary"> Begin the Journey</a>
                        <a href="${pageContext.request.contextPath}/files/DARK_MOON.zip" download="DARK_MOON.zip"
                            class="btn btn-primary">
                            &#9670; Tải xuống
                        </a>
                        <button onclick="openVideo()" class="btn btn-primary">
                            Xem Trailer &#9658;
                        </button>
                    </div>
                </div>

            </div>
        </section>

        <!-- ============================================================
                                    VIDEO
        ============================================================= -->

        <div id="videoModal" class="video-modal" onclick="closeVideo()">

            <div class="video-container" onclick="event.stopPropagation()">

                <video id="videoPlayer" controls>
                    <source src="${pageContext.request.contextPath}/video/trailer.mp4" type="video/mp4">
                </video>

            </div>

        </div>


        <!-- ============================================================
                                    GAME FEATURES
        ============================================================= -->

        <!-- <section class="section section-surface" style="padding:2.5rem 2rem;">
            <div class="container">
                <div style="display:grid; grid-template-columns:repeat(4,1fr); gap:1rem; text-align:center;">
                    <div style="padding:1.2rem; border:1px solid var(--border-dark);">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#9760;</span>
                        <span class="font-Cormorant Garamond text-parchment"
                            style="font-size:0.7rem; letter-spacing:0.15em; text-transform:uppercase;">Permadeath</span>
                    </div>
                    <div style="padding:1.2rem; border:1px solid var(--border-dark);">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#128997;</span>
                        <span class="font-Cormorant Garamond text-parchment"
                            style="font-size:0.7rem; letter-spacing:0.15em; text-transform:uppercase;">Sanity
                            System</span>
                    </div>
                    <div style="padding:1.2rem; border:1px solid var(--border-dark);">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#9876;</span>
                        <span class="font-Cormorant Garamond text-parchment"
                            style="font-size:0.7rem; letter-spacing:0.15em; text-transform:uppercase;">100+
                            Relics</span>
                    </div>
                    <div style="padding:1.2rem; border:1px solid var(--border-dark);">
                        <span style="font-size:1.8rem; display:block; margin-bottom:0.5rem;">&#127981;</span>
                        <span class="font-Cormorant Garamond text-parchment"
                            style="font-size:0.7rem; letter-spacing:0.15em; text-transform:uppercase;">Procedural
                            Dungeons</span>
                    </div>
                </div>
            </div>
        </section> -->

        <!-- ================================================================
                                    STORY TEASER
        ================================================================= -->

        <section class="section section-dark">
            <div class="container">
                <div class="split-section">
                    <div class="split-img-wrapper">
                        <img src="${pageContext.request.contextPath}/img/story.png" alt="Dark Forest" loading="lazy">
                    </div>
                    <div class="split-text">
                        <div class="split-tag">Khởi nguyên</div>
                        <h2 class="split-title">Ánh sáng của hy vọng</h2>
                        <div class="split-divider"></div>
                        <p class="split-body">
                            Sau hàng ngàn năm chiến tranh và hỗn loạn triền miên, thế giới cuối cùng đã được thống nhất
                            dưới sự cai trị của ba chủng tộc vĩ đại: Loài người, Tiên và Quỷ.
                            Lần đầu tiên sau vô số thời đại, người dân trên thế giới chứng kiến ​​một tia sáng le lói —
                            ánh sáng của hy vọng, thịnh vượng và hòa bình.
                            Dưới sự dẫn dắt của Tam Quốc và tầm nhìn về sự hài hòa, nền văn minh đã tiến bộ vượt bậc.
                            Những thành phố tráng lệ bằng đá trắng và vàng vươn lên trời cao, ma thuật huyền bí hòa
                            quyện với máy móc, và bầu trời tràn ngập những khinh khí cầu khổng lồ bay lượn giữa các
                            vương quốc rực rỡ.
                        </p>
                        <p class="split-body">
                            Tiên chia sẻ trí tuệ cổ xưa và sự làm chủ thiên nhiên của họ.
                            Loài người đã xây dựng nên những đế chế công nghiệp và đổi mới rộng lớn.
                            Quỷ, từng bị sợ hãi như những kẻ mang đến sự hủy diệt, đã trở thành người bảo vệ sức mạnh và
                            sự cân bằng.
                        </p>
                        <a href="/story" class="btn btn-primary">Đọc toàn bộ</a>
                    </div>
                </div>
            </div>
        </section>


        <!-- ==================================================================
                                    CHARACTER PREVIEW
        =================================================================== -->




        <section class="section section-darker">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Tội Nhân</span>
                    <h2 class="section-title">Kẻ cầm quyền tàn ác</h2>
                    <p class="section-subtitle">Những tàn hồn liên kết cùng nhau bởi tuyệt vọng và hắc ý.</p>
                    <div class="section-divider"></div>
                </div>
                <div class="grid-4">
                    <div class="character-card">
                        <img class="character-card-img" src="${pageContext.request.contextPath}/img/Kethanhtrung.png"
                            alt="Plague Doctor" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Nhân loại</span>
                            <h3 class="character-name">Clark</h3>
                            <div class="character-quote">"Science shall conquer even ."</div>
                        </div>
                    </div>
                    <div class="character-card">
                        <img class="character-card-img" src="${pageContext.request.contextPath}/img/Thomo.png"
                            alt="Hellion" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Ma vật</span>
                            <h3 class="character-name">Liễu Như Yên</h3>
                            <div class="character-quote">"Hãy để huyết nhuộm đại địa."</div>
                        </div>
                    </div>
                    <div class="character-card">
                        <img class="character-card-img" src="${pageContext.request.contextPath}/img/Giaochu.png"
                            alt="Crusader" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Ma vật</span>
                            <h3 class="character-name">Đỗ Nhật Quang</h3>
                            <div class="character-quote">"Niềm tin nâng đỡ chúng ta"</div>
                        </div>
                    </div>
                    <div class="character-card">
                        <img class="character-card-img" src="${pageContext.request.contextPath}/img/Dieutravien.png"
                            alt="Vestal" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Elf</span>
                            <h3 class="character-name">Mahiru</h3>
                            <div class="character-quote">"Ngay cả ánh sáng cũng chẳng giấu được bóng tối."</div>
                        </div>
                    </div>
                </div>
                <div class="text-center mt-4">
                    <a href="/characters" class="btn btn-secondary">Xem thêm</a>
                </div>
            </div>
        </section>


        <!-- ==================================================================
                                    QUOTE SECTION
        =================================================================== -->


        <section class="section section-surface" style="padding:5rem 2rem;">
            <div class="container-sm">
                <div class="quote-block">
                    <p class="quote-text">
                        Hãy ghi nhớ: đích đến vốn chẳng phải là điều trọng yếu. Xưa nay chưa từng là như vậy.
                        Sự trầm giáng mới là mục đích. Hắc ám mới là đáp án.
                        Ngươi hoặc sẽ tái xuất sau khi chinh phục cơn ác mộng —
                        hoặc sẽ vĩnh viễn không tái xuất nữa.
                    </p>
                    <span class="quote-author">— The Ancestor, Final Testament</span>
                </div>
            </div>
        </section>

        <!-- ==================================================================
                                    NEWS PREVIEW
        =================================================================== -->


        <section class="section section-dark">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Thông điệp từ vực thẳm</span>
                    <h2 class="section-title">Tin tức</h2>
                    <div class="section-divider"></div>
                </div>
                <div class="grid-3">
                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1534447677768-be436bb09401?w=600&q=80" alt="News 1"
                            loading="lazy">
                        <div class="card-body">
                            <span class="card-tag">Bản cập nhật 2.4 </span>
                            <h3 class="card-title">Cân bằng lại Crimson Court</h3>
                            <p class="card-text">Đám huyết tộc quý nhân đã được tái điều chỉnh.
                            Những kháng tính dị hoạn cùng quy luật chiến đấu mới đã trải qua sáu tháng nội bộ khảo nghiệm..</p>
                        </div>
                        <div class="card-footer">
                            <span class="font-Cormorant Garamond text-grey" style="font-size:0.58rem; letter-spacing:0.15em;">Oct
                                15, 2024</span>
                            <a href="/news" class="text-crimson font-Cormorant Garamond"
                                style="font-size:0.62rem; letter-spacing:0.15em;">Read More &#8594;</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=600&q=80" alt="News 2"
                            loading="lazy">
                        <div class="card-body">
                            <span class="card-tag">DLC — The Sunken City</span>
                            <h3 class="card-title">Khu vực mới: Kho tàng vực sâu</h3>
                            <p class="card-text">Bên dưới những phế tích bị thủy triều nhấn chìm là các cấm thư đã bị thế nhân lãng quên.
                            Tân dị thú, tân di vật, cùng những phương thức mới để nghênh đón tận diệt đang chờ đợi ngươi.</p>
                        </div>
                        <div class="card-footer">
                            <span class="font-Cormorant Garamond text-grey" style="font-size:0.58rem; letter-spacing:0.15em;">Oct 3,
                                2024</span>
                            <a href="/news" class="text-crimson font-Cormorant Garamond"
                                style="font-size:0.62rem; letter-spacing:0.15em;">Đọc thêm &#8594;</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1475738198235-5e1f7f8d8395?w=600&q=80" alt="News 3"
                            loading="lazy">
                        <div class="card-body">
                            <span class="card-tag">Cộng đồng</span>
                            <h3 class="card-title">Tuyển tập fan art: Tháng chín</h3>
                            <p class="card-text">Cộng đồng một lần nữa đã tạo nên những tuyệt tác sinh ra từ hắc ám.
                        Tuyển tập kỳ này sẽ trình hiện hai mươi bốn tác phẩm kinh tâm động phách.</p>
                        </div>
                        <div class="card-footer">
                            <span class="font-Cormorant Garamond text-grey" style="font-size:0.58rem; letter-spacing:0.15em;">Sep
                                28, 2024</span>
                            <a href="/news" class="text-crimson font-Cormorant Garamond"
                                style="font-size:0.62rem; letter-spacing:0.15em;">Read More &#8594;</a>
                        </div>
                    </div>
                </div>
                <div class="text-center mt-4">
                    <a href="/news" class="btn btn-secondary">Xem tất cả</a>
                </div>
            </div>
        </section>



        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>