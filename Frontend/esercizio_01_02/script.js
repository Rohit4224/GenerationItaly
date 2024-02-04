const movingButton = document.getElementById('movingButton');

function moveButton() {
  const maxX = window.innerWidth - movingButton.offsetWidth;
  const maxY = window.innerHeight - movingButton.offsetHeight;

  const randomX = Math.random() * maxX;
  const randomY = Math.random() * maxY;

  movingButton.style.left = randomX + 'px';
  movingButton.style.top = randomY + 'px';
}
