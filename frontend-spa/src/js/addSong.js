export {
    displayAddNewSong
}
import{
    renderAllAlbums,
    addNewSong
} from './app.js';

const displayAddNewSong = () => {

    const addASongElement = document.createElement('DIV');
    addASongElement.classList.add('single-song');

    const songAddTitle = document.createElement('H3');
    songAddTitle.classList.add('song-title');
    songAddTitle.innerHTML = 'Add A Song';

    const songNameAdd = document.createElement('input');
    songNameAdd.classList.add('song-input-name');
    songNameAdd.placeholder = "Song Name";

    // const songURL = document.createElement('input');
    // songURL.placeholder = "Song URL";

    const albumNameToAdd = document.createElement('input');
    albumNameToAdd.classList.add('album-input-name');
    albumNameToAdd.placeholder = "Song Album";

    const artistNameAdd = document.createElement('input');
    artistNameAdd.classList.add('artist-input-name');
    artistNameAdd.placeholder = "Artists Name";

    const addSongButton = document.createElement('button');
    addSongButton.classList.add('submit');
    addSongButton.innerHTML = "Submit";
    addSongButton.style.cursor = 'pointer';

    addASongElement.appendChild(songAddTitle);
    addASongElement.appendChild(songNameAdd);
    addASongElement.appendChild(albumNameToAdd);
    addASongElement.appendChild(artistNameAdd);
    addASongElement.appendChild(addSongButton);

    addSongButton.addEventListener('click', () => {
        
        let jsonObject = {
            "song name" : document.querySelector('.song-input-name').value,
            "album name" : document.querySelector('.album-input-name').value,
            "artist name" : document.querySelector('.artist-input-name').value
        };
        addNewSong(jsonObject);
    });

    return addASongElement;
}