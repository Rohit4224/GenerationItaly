const scroll = new LocomotiveScroll({
    el: document.querySelector('#main'),
    smooth: true
});

function videoContainerAnimation()
{
    var videocon = document.querySelector("#video-container");
    var playbtn = document.querySelector("#play");
    
    videocon.addEventListener("mouseenter", function() {
    /* playbtn.style.opacity = 1;
    playbtn.style.scale = 1; */
    gsap.to(playbtn,
        {
            opacity: 1, 
            scale: 1
        })
    });
    
    videocon.addEventListener("mouseleave", function() {
    /* playbtn.style.opacity = 0;
    playbtn.style.scale = 0; */
    gsap.to(playbtn,
        {
            opacity: 0, 
            scale: 0
        })
    });
    
    videocon.addEventListener("mousemove", function(dets) {
        gsap.to(playbtn,{
            left: dets.x -50,
            top: dets.y - 50
        })
    
    });
}

videoContainerAnimation();

function loadingAnimation()
{
    gsap.from("#page1 h1", {
        y:100,
        opacity: 0,
        delay: 0.5,
        duration: 0.9,
        stagger:0.3
  });

    gsap.from("#page1 #video-container", {
    scale:0.9,
    opacity: 0,
    delay: 1.3,
    duration: 0.3,
    });
}

loadingAnimation();


