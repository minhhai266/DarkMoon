<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <!-- FOOTER -->
    <footer>
        <div class="footer-grid">
            <div>
                <span class="footer-brand">MOON BLIGHT</span>
                <p class="footer-tagline">
                    Bước vào một thế giới bị bao phủ bởi bóng tối cổ xưa. Mỗi lựa chọn đều vang vọng khắp vùng đất đang
                    hấp hối.
                    Sự tỉnh táo là thứ quý giá nhất của bạn.
                </p>
                <div style="display:flex; gap:0.8rem; flex-wrap:wrap;">
                    <a href="/news" class="btn btn-outline-red" style="padding:0.5rem 1.2rem; font-size:0.62rem;">Tin
                        tức
                    </a>
                    <a href="/community" class="btn btn-secondary"
                        style="padding:0.5rem 1.2rem; font-size:0.62rem;">Tham gia cộng đồng</a>
                </div>
            </div>
            <div>
                <p class="footer-heading">Khám phá</p>
                <ul class="footer-links">
                    <li><a href="/story">Cốt truyện</a></li>
                    <li><a href="/characters">Nhân vật</a></li>
                    <li><a href="/enemies">Quái vật</a></li>
                    <li><a href="/weapons">Vũ khí &amp; Ký hiệu</a></li>
                    <li><a href="/world">Thế giới</a></li>
                </ul>
            </div>
            <div>
                <p class="footer-heading">Cộng đồng</p>
                <ul class="footer-links">
                    <li><a href="/news">Dev Blog</a></li>
                    <li><a href="/community">Discord</a></li>
                    <li><a href="/community">Reddit</a></li>
                    <li><a href="/community">Fan Art</a></li>
                    <li><a href="/community">Wiki</a></li>
                </ul>
            </div>
            <div>
                <p class="footer-heading">Hỗ trợ</p>
                <ul class="footer-links">
                    <li><a href="/support">FAQ</a></li>
                    <li><a href="/support">Liên hệ với chúng tôi</a></li>
                    <li><a href="/support">Báo cáo lỗi</a></li>
                    <li><a href="/support">Khả năng tiếp cận</a></li>
                    <li><a href="/support">Bộ tài liệu báo chí</a></li>
                </ul>
            </div>
        </div>

        <div class="footer-bottom">
            <p class="footer-copy">&copy; Trăng đen 2026. Bảo lưu mọi quyền. Bảo lưu mọi nỗi kinh hoàng.</p>
            <ul class="footer-legal">
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Terms</a></li>
                <li><a href="#">Cookies</a></li>
            </ul>
        </div>
    </footer>

    <!-- JAVASCRIPT (inline to avoid file-extension restrictions) -->
    <script src="${pageContext.request.contextPath}/js/index.js">
    </script>
    <!-- <script>
        const canvas = document.getElementById('sandstorm');
        const ctx = canvas.getContext('2d');

        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;

        window.addEventListener('resize', () => {
            canvas.width = window.innerWidth;
            canvas.height = window.innerHeight;
            initParticles();
        });

        // Luồng gió — chia màn hình thành các dải ngang
        const STREAMS = [
            { y: 0.15, spread: 0.06, count: 150, speed: 8 },
            { y: 0.32, spread: 0.04, count: 120, speed: 5 },
            { y: 0.50, spread: 0.08, count: 200, speed: 10 },
            { y: 0.65, spread: 0.05, count: 130, speed: 6 },
            { y: 0.82, spread: 0.07, count: 160, speed: 9 },
        ];

        let particles = [];
        let time = 0;

        function initParticles() {
            particles = [];
            STREAMS.forEach(stream => {
                for (let i = 0; i < stream.count; i++) {
                    particles.push(createParticle(stream, true));
                }
            });
        }

        function createParticle(stream, randomX = false) {
            const speed = stream.speed * (Math.random() * 0.4 + 0.8); // ±20% quanh speed luồng
            return {
                stream,
                x: randomX ? Math.random() * canvas.width : canvas.width + Math.random() * 300,
                // Y bám theo luồng + spread ngẫu nhiên
                baseY: stream.y * canvas.height,
                y: (stream.y + (Math.random() - 0.5) * stream.spread) * canvas.height,
                size: Math.random() * 0.6 + 0.2,           // hạt nhỏ hơn
                speed,
                length: speed * (Math.random() * 8 + 4),   // streak ngắn hơn
                waveAmp: Math.random() * 0.4 + 0.1,
                waveFreq: Math.random() * 0.015 + 0.003,
                waveOffset: Math.random() * Math.PI * 2,
                opacity: Math.random() * 0.55 + 0.15,
                // Màu cát sa mạc: vàng nâu ấm
                hue: Math.random() * 25 + 30,   // 30–55: vàng nâu → vàng cát
                sat: Math.random() * 25 + 55,   // 55–80%
                light: Math.random() * 25 + 55,   // 55–80% — sáng như cát
            };
        }

        function draw() {
            // Motion blur nhẹ
            ctx.fillStyle = 'rgba(0, 0, 0, 0.2)';
            ctx.fillRect(0, 0, canvas.width, canvas.height);

            for (let p of particles) {
                // Dao động nhẹ quanh baseY của luồng
                p.y = p.baseY + Math.sin(time * p.waveFreq * 60 + p.waveOffset) * p.waveAmp * 15;

                const grad = ctx.createLinearGradient(p.x + p.length, p.y, p.x, p.y);
                grad.addColorStop(0, `hsla(${p.hue}, ${p.sat}%, ${p.light}%, 0)`);
                grad.addColorStop(0.4, `hsla(${p.hue}, ${p.sat}%, ${p.light}%, ${p.opacity})`);
                grad.addColorStop(1, `hsla(${p.hue}, ${p.sat}%, ${p.light}%, 0)`);

                ctx.beginPath();
                ctx.moveTo(p.x + p.length, p.y);
                ctx.lineTo(p.x, p.y);
                ctx.strokeStyle = grad;
                ctx.lineWidth = p.size;
                ctx.stroke();

                p.x -= p.speed;

                if (p.x + p.length < -10) {
                    Object.assign(p, createParticle(p.stream, false));
                }
            }

            time++;
            requestAnimationFrame(draw);
        }

        initParticles();
        draw();
        // =============================================================================================================
        const navLinks = document.querySelectorAll(".nav-down");

        navLinks.forEach(link => {

            link.addEventListener("click", function () {

                const targetId = this.dataset.target;

                const targetSection = document.getElementById(targetId);

                targetSection.scrollIntoView({
                    behavior: "smooth"
                });

            });

        });
        window.addEventListener("load", function () {
            if (window.location.hash) {
                const targetId = window.location.hash.substring(1);
                const target = document.getElementById(targetId);
                if (target) {
                    setTimeout(() => target.scrollIntoView({ behavior: "smooth" }), 100);
                }
            }
        });
    </script> -->
    <script src="${pageContext.request.contextPath}/js/index2.js"></script>
    </body>

    </html>