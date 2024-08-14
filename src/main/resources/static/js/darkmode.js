

document.addEventListener("DOMContentLoaded", function() {
       const toggle = document.getElementById('darkModeToggle');
       const currentTheme = localStorage.getItem('theme') || 'light';

       // Apply the current theme
       if (currentTheme === 'dark') {
           document.body.classList.add('dark-mode');
           document.body.classList.remove('light-mode');
           toggle.checked = true;
       } else {
           document.body.classList.add('light-mode');
           document.body.classList.remove('dark-mode');
           toggle.checked = false;
       }

       // Listen for the toggle switch change
       toggle.addEventListener('change', function() {
           if (toggle.checked) {
               document.body.classList.add('dark-mode');
               document.body.classList.remove('light-mode');
               localStorage.setItem('theme', 'dark');
           } else {
               document.body.classList.add('light-mode');
               document.body.classList.remove('dark-mode');
               localStorage.setItem('theme', 'light');
           }
       });
   });