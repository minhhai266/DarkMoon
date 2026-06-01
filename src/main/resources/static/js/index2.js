// ============================================================
//  MOON BLIGHT — index.js
// ============================================================

document.addEventListener("DOMContentLoaded", function () {

    // --------------------------------------------------------
    //  1. NAVBAR SCROLL (event delegation — không bị null)
    // --------------------------------------------------------
    document.addEventListener("click", function (e) {
        const link = e.target.closest(".nav-down");
        if (!link) return;

        const targetId = link.dataset.target;
        if (!targetId) return;

        const section = document.getElementById(targetId);

        if (section) {
            // Đang ở trang chủ → scroll mượt
            e.preventDefault();
            section.scrollIntoView({ behavior: "smooth" });

            // Đóng mobile menu nếu đang mở
            closeMobileMenu();
        } else {
            // Ở trang khác → redirect về trang chủ kèm hash
            window.location.href = "/#" + targetId;
        }
    });

    // Xử lý hash khi vừa redirect về trang chủ
    if (window.location.hash) {
        const targetId = window.location.hash.substring(1);
        const target = document.getElementById(targetId);
        if (target) {
            setTimeout(() => target.scrollIntoView({ behavior: "smooth" }), 200);
            // Xóa hash trên URL cho sạch
            history.replaceState(null, "", window.location.pathname);
        }
    }

    // --------------------------------------------------------
    //  2. HAMBURGER MENU
    // --------------------------------------------------------
    const hamburger = document.getElementById("hamburger");
    const mobileMenu = document.getElementById("mobileMenu");

    if (hamburger && mobileMenu) {
        hamburger.addEventListener("click", function () {
            const isOpen = mobileMenu.classList.toggle("open");
            hamburger.setAttribute("aria-expanded", isOpen);
            mobileMenu.setAttribute("aria-hidden", !isOpen);
            hamburger.classList.toggle("active", isOpen);
        });

        // Đóng mobile menu khi click ra ngoài
        document.addEventListener("click", function (e) {
            if (!hamburger.contains(e.target) && !mobileMenu.contains(e.target)) {
                closeMobileMenu();
            }
        });
    }

    function closeMobileMenu() {
        if (!mobileMenu) return;
        mobileMenu.classList.remove("open");
        mobileMenu.setAttribute("aria-hidden", "true");
        if (hamburger) {
            hamburger.setAttribute("aria-expanded", "false");
            hamburger.classList.remove("active");
        }
    }

    // --------------------------------------------------------
    //  3. NAVBAR — đổi style khi scroll
    // --------------------------------------------------------
    const navbar = document.querySelector(".navbar");
    if (navbar) {
        window.addEventListener("scroll", function () {
            navbar.classList.toggle("scrolled", window.scrollY > 50);
        }, { passive: true });
    }

    // --------------------------------------------------------
    //  4. VIDEO MODAL
    // --------------------------------------------------------
    window.openVideo = function () {
        const modal = document.getElementById("videoModal");
        const player = document.getElementById("videoPlayer");
        if (modal) modal.style.display = "flex";
        if (player) player.play();
    };

    window.closeVideo = function () {
        const modal = document.getElementById("videoModal");
        const player = document.getElementById("videoPlayer");
        if (modal) modal.style.display = "none";
        if (player) player.pause();
    };

    // Đóng video bằng phím Escape
    document.addEventListener("keydown", function (e) {
        if (e.key === "Escape") window.closeVideo();
    });

});