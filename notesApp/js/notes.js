const daysGR = ['Κυριακή', 'Δευτέρα', 'Τρίτη', 'Τετάρτη', 'Πέμπτη', 'Παρασκευή', 'Σάββατο']
const monthsGR = ['Ιανουαρίου', 'Φεβρουαρίου', 'Μαρτίου', 'Απριλίου', 'Μαΐου', 'Ιουνίου', 'Αυγούστου', 
    'Σεπτεμβρίου', 'Οκτωβρίου', 'Νοεμβρίου', 'Δεκεμβρίου']


window.addEventListener('DOMContentLoaded', function() {
    
    this.setInterval(printGRDate, 1000)

    document.querySelector('.btn').addEventListener('click', function() {
        insertNote(document.querySelector('#noteText').value.trim())
        reset()
    })

    document.querySelector('#noteText').addEventListener('keyup', function(e) {
        if (e.key === 'Enter') {
            insertNote(this.value.trim())
            reset()
        }
    })

})    

function printGRDate() {
    const currentDate = new Date()
    const day = currentDate.getDay()
    const date = currentDate.getDate()
    const month = currentDate.getMonth()
    const year = currentDate.getFullYear()
    const hours = currentDate.getHours()
    const minutes = currentDate.getMinutes()
    const seconds = currentDate.getSeconds()

    let formattedDay = daysGR[day]
    let formattedMonth = monthsGR[month]

    let formattedDate = `${formattedDay}, ${date}, ${formattedMonth}, ${year}`
    let formattedTime = `${(hours < 0 ? '0' : '')}${hours}
                        :${(minutes < 10) ? '0' : ''}${minutes}
                        :${(seconds < 10) ? '0' : ''}${seconds}`

    document.querySelector('.header').innerHTML = formattedDate 
                                                + "<br>"
                                                + formattedTime

}

function insertNote(note) {
    if (!note) {
        return
    }

    let clone = document.querySelector('.row.hidden').cloneNode(true)
    clone.classList.remove('hidden')

    clone.querySelector('input').addEventListener('click', function() {
        strikeThrough(clone.querySelector('label'))
    })

    clone.querySelector('button').addEventListener('click', function() {
        deleteNote(this.parentNode)
    })

    clone.querySelector('label').innerHTML = note
    document.querySelector('.main').appendChild(clone)
    // document.querySelector('#noteText').placeholder = 'Note'
}

function strikeThrough(lbl) {
    lbl.classList.toggle('line-through')
}

function deleteNote(note) {
    note.remove()
}

function reset() {
    document.querySelector('#noteText').value = ''
}



