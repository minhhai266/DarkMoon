<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <section class="page-hero">
            <div class="page-hero-bg"
                style="background-image:url('https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1920&q=80');">
            </div>
            <div class="page-hero-overlay"></div>
            <div class="page-hero-content">
                <p class="page-hero-eyebrow">&#9670; Huyết Chiến Danh Lục &#9670;</p>
                <h1 class="page-hero-title">Nhân vật</h1>
                <p class="page-hero-subtitle">Mỗi anh hùng đều mang theo những thương tích — cả hữu hình lẫn ẩn sâu
                    trong tâm trí.
                    Hãy lựa chọn thật cẩn trọng, bởi họ sẽ không tha thứ cho ngươi nếu sự hy sinh của họ bị lãng phí.
                </p>
            </div>
        </section>

        <!-- INTRO -->
        <section style="background:var(--dark-surface); padding:3rem 2rem; text-align:center;">
            <div class="container-sm">
                <p class="font-im-fell" style="font-size:1.15rem; color:var(--mid-grey); line-height:1.9;">
                    Thập tứ lớp tàn hồn đã đáp lại lời triệu hồi của ngươi.
                    Mỗi kẻ mang theo những kỹ năng riêng biệt cho cuộc viễn chinh bị nguyền rủa — và những cách thức
                    riêng để sụp đổ dưới áp lực.
                    Những đức tính của họ chính là sức mạnh lớn nhất.
                    Còn những ác chứng của họ — là gánh nặng mà ngươi phải tự mình kiểm soát.
                </p>
            </div>
        </section>

        <!-- CHARACTERS GRID -->
        <section class="section section-dark">
            <div class="container">
                <div class="grid-4">

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1541534741688-6078c6bfb5c5?w=400&q=80"
                            alt="Plague Doctor" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Support / Control</span>
                            <h3 class="character-name">Plague Doctor</h3>
                            <div class="character-quote">"Pathology is merely nature's way of negotiating."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:55%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:40%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:70%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1578632767115-351597cf2477?w=400&q=80" alt="Hellion"
                            loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Frontline / Melee</span>
                            <h3 class="character-name">Hellion</h3>
                            <div class="character-quote">"Every war ends the same. In blood."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:88%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:50%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:45%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=400&q=80" alt="Crusader"
                            loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Tank / Frontline</span>
                            <h3 class="character-name">Crusader</h3>
                            <div class="character-quote">"The light of righteousness shall scour these halls."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:65%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:85%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:35%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=400&q=80" alt="Vestal"
                            loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Healer / Support</span>
                            <h3 class="character-name">Vestal</h3>
                            <div class="character-quote">"To heal is to understand what it means to break."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:40%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:55%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:60%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1519125323398-675f0ddb6308?w=400&q=80"
                            alt="Bounty Hunter" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Damage / Utility</span>
                            <h3 class="character-name">Bounty Hunter</h3>
                            <div class="character-quote">"The price on your head pays my debts."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:75%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:60%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:65%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?w=400&q=80" alt="Arbalest"
                            loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Ranged / Marksman</span>
                            <h3 class="character-name">Arbalest</h3>
                            <div class="character-quote">"Distance is not cowardice. Distance is strategy."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:80%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:30%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:55%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1568605114967-8130f3a36994?w=400&q=80"
                            alt="Occultist" loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Mystic / Debuffer</span>
                            <h3 class="character-name">Occultist</h3>
                            <div class="character-quote">"The eldritch is not evil. It is simply indifferent."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:70%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:25%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:72%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="character-card">
                        <img class="character-card-img"
                            src="https://images.unsplash.com/photo-1552058544-f2b08422138a?w=400&q=80" alt="Leper"
                            loading="lazy">
                        <div class="character-card-body">
                            <span class="character-class">Heavy Melee</span>
                            <h3 class="character-name">Leper</h3>
                            <div class="character-quote">"I have lost everything that can be taken. What remains is
                                will."</div>
                            <div class="stat-bars">
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">ATTACK</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:92%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">DEFENSE</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill" style="width:70%;"></div>
                                    </div>
                                </div>
                                <div class="stat-bar-row">
                                    <span class="stat-bar-label">SPEED</span>
                                    <div class="stat-bar-track">
                                        <div class="stat-bar-fill amber" style="width:20%;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </section>

        <!-- AFFLICTION SYSTEM -->
        <section class="section section-surface">
            <div class="container">
                <div class="split-section reverse">
                    <div class="split-img-wrapper">
                        <img src="https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=800&q=80"
                            alt="Affliction" loading="lazy">
                    </div>
                    <div class="split-text">
                        <div class="split-tag">The Breaking Point</div>
                        <h2 class="split-title">Virtues &amp; Afflictions</h2>
                        <div class="split-divider"></div>
                        <p class="split-body">
                            Không một anh hùng nào có thể đối mặt với vực thẳm mà không mang thương tổn. Khi áp lực dần
                            chồng chất, họ sẽ chạm tới giới hạn tinh thần.
                            Một số tìm thấy ý chí sâu thẳm bên trong — thức tỉnh những <strong
                                style="color:var(--gold);">Đức Hạnh</strong>
                            mạnh mẽ, biến tuyệt vọng thành sức mạnh.
                        </p>
                        <p class="split-body">
                            Những kẻ khác thì gục ngã. Các <strong style="color:var(--crimson);">Chứng Loạn Tâm</strong>
                            như Hoang Tưởng,
                            Ích Kỷ hay Khổ Dâm bắt đầu chiếm lấy tâm trí —khiến họ chống lại đồng đội, phá hoại hành
                            động của cả tổ đội,
                            và đẩy chính bản thân đến diệt vong nhanh hơn.
                        </p>
                        <p class="split-body">
                            Ngay cả một chiến binh dày dạn trận mạc với đầy đủ trang bị
                            cũng có thể trở thành mối hiểm họa lớn nhất của ngươi
                            nếu tinh thần của họ sụp đổ trước tiên.
                        </p>
                    </div>
                </div>
            </div>
        </section>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>