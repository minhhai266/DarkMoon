<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <!-- HERO -->
        

        
            <section id="home" class="hero">

                <div class="hero-bg"
                    style="background-image:url('${pageContext.request.contextPath}/img/backgroud.png');">
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
                        <!-- <p class="hero-desc">
                        Thiên hạ đã diệt vong. Tà lực cổ xưa đang thống trị cõi trần.
                        Ngươi phải hiệu triệu một đoàn tàn hồn và tiến nhập hắc ám —
                        nơi thần trí còn hiếm quý hơn kim ngân, và từ bi là xa xỉ phẩm mà ngươi không thể lưu giữ.
                    </p> -->
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
        <div class="hero-spacer"></div>
        <!-- ============================================================
                                    VIDEO
        ============================================================= -->
<div class="content-wrapper">

        <div id="videoModal" class="video-modal" onclick="closeVideo()">

            <div class="video-container" onclick="event.stopPropagation()">

                <video id="videoPlayer" controls>
                    <source src="${pageContext.request.contextPath}/video/trailer.mp4" type="video/mp4">
                </video>

            </div>

        </div>


        

    <div class="parallax-wrapper">

        <!-- ================================================================
                                    STORY TEASER
        ================================================================= -->
        <section id="story" class="section section-dark section-stack">
            <!-- <div class="hero-bg"
                    style="background-image:url('${pageContext.request.contextPath}/img/section2-back.png');">
                </div>
                <div class="hero-overlay"></div>
                <div class="hero-vignette"></div> -->
            <div class="container">
                <div class="split-section">
                    <div class="split-img-wrapper">
                        <img src="${pageContext.request.contextPath}/img/start-story.png" alt="Dark Forest" loading="lazy">
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
                                    World
        =================================================================== -->



        <section id="world" class="section-world" >
            <div class="container">
                <div class="split-section">
                    <div class="split-text">
                        <div class="split-tag">Vùng đất</div>
                        <h2 class="split-title">Giáo hội thiên thể</h2>
                        <div class="split-divider"></div>
                        <p class="split-body">
                            Giáo Hội Thiên Thể từng là biểu tượng tối cao của Oakhaven — một thế lực thần quyền bao trùm
                            toàn bộ thành phố bằng những đại giáo đường nguy nga, thánh điện phủ ánh tinh quang và các
                            quảng trường thanh tẩy rực cháy dưới ánh đuốc thiêng. Người dân nơi đây quỳ lạy “Ánh Sáng Từ
                            Các Vì Sao”, tin rằng chỉ có sự thuần khiết tuyệt đối mới cứu rỗi linh hồn nhân loại.
                        </p>
                        <p class="split-body">
                            Nhưng đức tin ấy từ lâu đã mục rữa từ bên trong. Những nghi thức thanh tẩy cực đoan, các
                            cuộc săn lùng dị giáo và sự cuồng tín mù quáng đã biến Oakhaven thành một vùng đất bị nguyền
                            rủa. Bên dưới các thánh đường cổ kính, những mật thất và hầm nguyện tăm tối đã bị khai mở,
                            giải phóng các thực thể dị dạng lan tràn khắp thành phố. Giữa cơn suy vong ấy, khu dân cư
                            trung tâm — thành trì cuối cùng của văn minh — vẫn đang hấp hối tồn tại dưới cái bóng của
                            Giáo Hội.

                        </p>
                        <p class="split-body">
                            Bao quanh Oakhaven là năm khu vực tà dị riêng biệt, mỗi nơi mang một hình thái kinh hãi khác
                            nhau: từ những tu viện đổ nát phủ đầy huyết tự, các hầm mộ bị ánh sao nguyền rủa xâm thực,
                            cho đến bến cảng mục nát nơi tín đồ điên loạn hành lễ dưới triều đêm. Mỗi vùng đất đều cất
                            giấu một chân tướng khủng khiếp — cùng cuộc đối diện cuối cùng đang chờ đợi kẻ dám tiến sâu
                            vào bóng tối.

                        </p>
                        <a href="/world" class="btn btn-primary">Khám phá thế giới</a>

                    </div>
                    <div class="split-img-wrapper">
                        <img src="${pageContext.request.contextPath}/img/img4.png" alt="The Estate Map" loading="lazy">
                    </div>
                </div>
            </div>
            
        </section>
        <!-- ==================================================================
                                    CHARACTER PREVIEW
        =================================================================== -->
        



        <section id="character" class="section section-darker section-stack">
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
                            <div class="character-quote">"Khoa học là vĩnh hằng. Ta là người khám phá ra nó."</div>
                        </div>
                    </div>
                    <div class="character-card">
                        <img class="character-card-img" src="${pageContext.request.contextPath}/img/Thomo.png"
                            alt="Hellion" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Ma vật</span>
                            <h3 class="character-name">Liễu Như Yên</h3>
                            <div class="character-quote">"Hãy để huyết nhuộm đại địa.Hãy mang huyết đến cho ta."</div>
                        </div>
                    </div>
                    <div class="character-card">
                        <img class="character-card-img" src="${pageContext.request.contextPath}/img/Giaochu.png"
                            alt="Crusader" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Ma vật</span>
                            <h3 class="character-name">Đỗ Nhật Quang</h3>
                            <div class="character-quote">"Niềm tin nâng đỡ chúng ta là vĩnh hằng không thể thay đổi."</div>
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

        </div>


        <!-- ==================================================================
                                    QUOTE SECTION
        =================================================================== -->
        <div class="backgroud-img">

        <section  class="section section-surface section-stack" style="padding:5rem 2rem;">
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


        <section id="news" class="section section-dark section-stack">
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
                                Những kháng tính dị hoạn cùng quy luật chiến đấu mới đã trải qua sáu tháng nội bộ khảo
                                nghiệm thế giới này cực kì nguy hiểm.Thật thảm hại</p>
                        </div>
                        <div class="card-footer">
                            <span class="font-Cormorant Garamond text-grey"
                                style="font-size:0.58rem; letter-spacing:0.15em;">Oct
                                15, 2024</span>
                            <a href="/news" class="text-crimson font-Lora"
                                style="font-size:0.82rem; letter-spacing:0.12em;">Đọc thêm &#8594;</a>
                        </div>
                    </div>
                    <div class="card">
                        <img class="card-img"
                            src="https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=600&q=80" alt="News 2"
                            loading="lazy">
                        <div class="card-body">
                            <span class="card-tag">DLC — The Sunken City</span>
                            <h3 class="card-title">Khu vực mới: Kho tàng vực sâu</h3>
                            <p class="card-text">Bên dưới những phế tích bị thủy triều nhấn chìm là các cấm thư đã bị
                                thế nhân lãng quên.Tân dị thú, tân di vật, cùng những phương thức mới để nghênh đón tận diệt đang chờ đợi
                                ngươi.</p>
                        </div>
                        <div class="card-footer">
                            <span class="font-Cormorant Garamond text-grey"
                                style="font-size:0.58rem; letter-spacing:0.15em;">Oct 3,
                                2024</span>
                            <a href="/news" class="text-crimson font-Lora"
                                style="font-size:0.82rem; letter-spacing:0.12em;">Đọc thêm &#8594;</a>
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
                                Tuyển tập kỳ này sẽ trình hiện hai mươi bốn tác phẩm kinh tâm động phách.Đám huyết tộc quý nhân đã được tái điều chỉnh.</p>
                        </div>
                        <div class="card-footer">
                            <span class="font-Cormorant Garamond text-grey"
                                style="font-size:0.58rem; letter-spacing:0.15em;">Sep
                                28, 2024</span>
                            <a href="/news" class="text-crimson font-Lora"
                                style="font-size:0.82rem; letter-spacing:0.12em;">Đọc thêm &#8594;</a>
                        </div>
                    </div>
                </div>
                <div class="text-center mt-4">
                    <a href="/news" class="btn btn-secondary">Xem tất cả</a>
                </div>
            </div>
        </section>

        
        <!-- Footer -->
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
        </div>
        </div>
