const toggle = document.getElementById('toggle')
const label = document.getElementById('label')

toggle.addEventListener('change', (e) => {
    document.body.classList.toggle('dark',
        e.target.checked)

    if(label.innerText === "Change to Dark Mode"){
        label.innerText = "Change to Light Mode"
    }else{
        label.innerText = "Change to Dark Mode"
    }
})