<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>

        <section class="page-hero">
            <div class="page-hero-bg"
                style="background-image:url('https://images.unsplash.com/photo-1599508704512-2f19efd1e35f?w=1920&q=80');">
            </div>
            <div class="page-hero-overlay"></div>
            <div class="page-hero-content">
                <p class="page-hero-eyebrow">&#9670; Kho Vũ Khí  &#9670;</p>
                <h1 class="page-hero-title">Vũ khí</h1>
                <p class="page-hero-subtitle">Mỗi lưỡi kiếm đều đã nhuốm máu. Mỗi cổ vật đều đi kèm một cái giá. Câu hỏi
                    là bạn có sẵn sàng trả cái giá đó hay không.</p>
            </div>
        </section>

        <!-- WEAPONS INTRO -->
        <section style="background:var(--dark-surface); padding:3rem 2rem; text-align:center;">
            <div class="container-sm">
                <p class="font-im-fell" style="font-size:1.15rem; color:var(--mid-grey); line-height:1.9;">
                    Hơn 400 loại vũ khí, phụ kiện và cổ vật đang nằm rải rác khắp các ngục tối bị nguyền rủa.
                    Một số mang lại sức mạnh. Một số mang lại sự điên loạn. Một số mang lại cả hai, và để bạn tự lựa
                    chọn thứ mình muốn.
                </p>
            </div>
        </section>

        <!-- WEAPONS LIST -->
        <section class="section section-dark">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Kho Vũ Khí</span>
                    <h2 class="section-title">Vũ khí của những kẻ bị nguyền rủa</h2>
                    <div class="section-divider"></div>
                </div>
                <div style="display:flex; flex-direction:column; gap:1rem;">

                    <div class="weapon-card">
                        <span class="weapon-icon">&#9876;</span>
                        <div>
                            <span class="weapon-rarity rarity-legendary">&#9670; Legendary</span>
                            <h3 class="weapon-name">The Ancestor's Knapsack</h3>
                            <p class="weapon-desc">"He carried it through every expedition. What it contains has never
                                been fully catalogued. Perhaps for good reason."
                                <br><small style="color:var(--ash-grey); font-style:normal;">+15% Crit, +2 Speed, -10
                                    Stress Resistance</small>
                            </p>
                        </div>
                    </div>

                    <div class="weapon-card">
                        <span class="weapon-icon">&#128481;</span>
                        <div>
                            <span class="weapon-rarity rarity-cursed">&#9670; Cursed</span>
                            <h3 class="weapon-name">Blade of the Unmaking</h3>
                            <p class="weapon-desc">"It does not cut through armor. It cuts through the concept of armor.
                                Heroes who wield it report hearing it speak to them in the dark."
                                <br><small style="color:var(--ash-grey); font-style:normal;">+25 Damage, +30% Blight
                                    Chance, Stress +5 on equip</small>
                            </p>
                        </div>
                    </div>

                    <div class="weapon-card">
                        <span class="weapon-icon">&#128013;</span>
                        <div>
                            <span class="weapon-rarity rarity-rare">&#9670; Rare</span>
                            <h3 class="weapon-name">Tome of Eldritch Whispers</h3>
                            <p class="weapon-desc">"The text rearranges itself when you're not looking. The notes in the
                                margins are not yours, but they are in your handwriting."
                                <br><small style="color:var(--ash-grey); font-style:normal;">+20% Skill Damage, Eldritch
                                    attacks marked</small>
                            </p>
                        </div>
                    </div>

                    <div class="weapon-card">
                        <span class="weapon-icon">&#9855;</span>
                        <div>
                            <span class="weapon-rarity rarity-uncommon">&#9670; Uncommon</span>
                            <h3 class="weapon-name">Hallowed Cudgel</h3>
                            <p class="weapon-desc">"Blessed by a priest who later fled the estate screaming. The
                                blessing held, though. That's what matters."
                                <br><small style="color:var(--ash-grey); font-style:normal;">+8 Damage vs Undead, +5
                                    Stress Resistance</small>
                            </p>
                        </div>
                    </div>

                    <div class="weapon-card">
                        <span class="weapon-icon">&#127981;</span>
                        <div>
                            <span class="weapon-rarity rarity-cursed">&#9670; Cursed</span>
                            <h3 class="weapon-name">The Crimson Chalice</h3>
                            <p class="weapon-desc">"Drink from it and you are healed. Drink too often and you begin to
                                need it. The Court watches those who need it."
                                <br><small style="color:var(--ash-grey); font-style:normal;">Heal 8 HP on kill. After 5
                                    kills: Contract Crimson Curse</small>
                            </p>
                        </div>
                    </div>

                    <div class="weapon-card">
                        <span class="weapon-icon">&#128208;</span>
                        <div>
                            <span class="weapon-rarity rarity-rare">&#9670; Rare</span>
                            <h3 class="weapon-name">Vestal's Reliquary</h3>
                            <p class="weapon-desc">"It is said to contain the finger-bone of a saint. Whether that saint
                                would approve of how it is being used is another matter entirely."
                                <br><small style="color:var(--ash-grey); font-style:normal;">+15% Healing Skills, -5
                                    Damage Taken from Eldritch</small>
                            </p>
                        </div>
                    </div>

                    <div class="weapon-card">
                        <span class="weapon-icon">&#9763;</span>
                        <div>
                            <span class="weapon-rarity rarity-legendary">&#9670; Legendary</span>
                            <h3 class="weapon-name">Signet of the Ancestor</h3>
                            <p class="weapon-desc">"He wore this to every summoning. It still smells of whatever he was
                                burning on those evenings. The heroes who wear it hear his voice on long expeditions."
                                <br><small style="color:var(--ash-grey); font-style:normal;">+15% All Resistances,
                                    Ancestor's Commentary unlocked in camp</small>
                            </p>
                        </div>
                    </div>

                    <div class="weapon-card">
                        <span class="weapon-icon">&#127935;</span>
                        <div>
                            <span class="weapon-rarity rarity-common">&#9670; Common</span>
                            <h3 class="weapon-name">Torch of Vigil</h3>
                            <p class="weapon-desc">"Ánh sáng nó tỏa ra chưa bao giờ chạm tới được những góc tối sâu
                                nhất.
                                Nhưng có nó… vẫn tốt hơn là không có. Dù chỉ đôi chút."
                                <br><small style="color:var(--ash-grey); font-style:normal;">+15 Ánh Sáng. Không thể bị
                                    dập tắt bởi hành động của kẻ địch.</small>
                            </p>
                        </div>
                    </div>

                </div>
            </div>
        </section>

        <!-- RARITY SYSTEM -->
        <section class="section section-surface">
            <div class="container">
                <div class="section-header">
                    <span class="section-eyebrow">Phân Loại
                    </span>
                    <h2 class="section-title">Độ Hiếm & Rủi Ro</h2>
                    <p class="section-subtitle">Sức mạnh càng lớn, cái giá phải trả càng nặng nề.
                        Hầm ngục này chưa từng ban phát lòng nhân từ.</p>
                    <div class="section-divider"></div>
                </div>
                <div class="grid-3">
                    <div class="card" style="padding:2rem; text-align:center;">
                        <span class="weapon-rarity rarity-common"
                            style="font-size:0.8rem; margin-bottom:0.8rem; display:block;">&#9670; Thường Gặp</span>
                        <p class="card-text">Trang bị đáng tin cậy với những chỉ số cộng thêm vừa phải.
                            Không mang bất kỳ tác dụng phụ nào.
                            Nền tảng cho mọi chuyến viễn chinh.</p>
                    </div>
                    <div class="card" style="padding:2rem; text-align:center;">
                        <span class="weapon-rarity rarity-uncommon"
                            style="font-size:0.8rem; margin-bottom:0.8rem; display:block;">&#9670; Không Phổ Biến</span>
                        <p class="card-text">Chỉ số được cường hóa cùng những hiệu ứng lợi thế theo tình huống.
                            Có vài điểm kỳ lạ nhỏ, nhưng nhìn chung đều mang lại lợi ích.
                            Rất đáng để săn tìm.</p>
                    </div>
                    <div class="card" style="padding:2rem; text-align:center;">
                        <span class="weapon-rarity rarity-rare"
                            style="font-size:0.8rem; margin-bottom:0.8rem; display:block;">&#9670; Hiếm</span>
                        <p class="card-text">Những năng lực mạnh mẽ đi kèm với cái giá tương xứng.
                            Hãy xây dựng tổ đội xoay quanh chúng khi có thể.</p>
                    </div>
                    <div class="card" style="padding:2rem; text-align:center;">
                        <span class="weapon-rarity rarity-legendary"
                            style="font-size:0.8rem; margin-bottom:0.8rem; display:block;">&#9670; Truyền Thuyết</span>
                        <p class="card-text">Sức mạnh có thể thay đổi toàn bộ cuộc chơi.
                            Định hình vận mệnh của cả tổ đội.
                            Mỗi món đều là độc nhất, và chỉ có thể đạt được ở giai đoạn cuối hành trình.</p>
                    </div>
                    <div class="card" style="padding:2rem; text-align:center;">
                        <span class="weapon-rarity rarity-cursed"
                            style="font-size:0.8rem; margin-bottom:0.8rem; display:block;">&#9670; Bị Nguyền Rủa</span>
                        <p class="card-text">Những cổ vật nguy hiểm nhất trong hầm ngục.
                            Sức mạnh vượt ngoài giới hạn — nhưng cái giá phải trả cũng vượt ngoài sức tưởng tượng.
                            Chỉ sử dụng khi ngươi thật sự hiểu được hậu quả của nó..</p>
                    </div>
                    <div class="card" style="padding:2rem; text-align:center;">
                        <span
                            style="font-family:'Cormorant Garamond',serif; font-size:0.8rem; color:var(--mid-grey); margin-bottom:0.8rem; display:block;">&#9670;
                            Độc Nhất</span>
                        <p class="card-text">Những con trùm không chỉ là kẻ cản đường — mỗi trận chiến đều mang ý nghĩa
                            riêng trong cốt truyện.
                            Mỗi boss đều kể một câu chuyện, và một số sẽ thay đổi cách tương tác tùy theo lịch sử cùng
                            lựa chọn của tổ đội ngươi.</p>
                    </div>
                </div>
            </div>
        </section>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>