export {
    displayAddNewSong
}
import{
    renderAllAlbums,
    addNewSong
} from './app.js';

const displayAddNewSong = (id) => {
    console.log();
    const addASongElement = document.createElement('DIV');
    addASongElement.classList.add('single-song');

    // const songAddTitle = document.createElement('H3');
    // songAddTitle.classList.add('song-title');
    // songAddTitle.innerHTML = 'Add A Song';

    const songNameAdd = document.createElement('input');
    songNameAdd.classList.add('song-input-name');
    songNameAdd.placeholder = "Song Name";

    // const songURL = document.createElement('input');
    // songURL.placeholder = "Song URL";

    // const albumNameToAdd = document.createElement('div');
    // albumNameToAdd.classList.add('album-input-name');
    // albumNameToAdd.innerHTML = albumToAddSongTo.artist.name;

    const artistNameAdd = document.createElement('div');
    artistNameAdd.classList.add('artist-input-name');
    artistNameAdd.placeholder = "Artists Name";

    const addSongButton = document.createElement('button');
    addSongButton.classList.add('submit');
    addSongButton.innerHTML = "Submit";
    addSongButton.style.cursor = 'pointer';

    // addASongElement.appendChild(songAddTitle);
    addASongElement.appendChild(songNameAdd);
    // addASongElement.appendChild(albumNameToAdd);
    addASongElement.appendChild(artistNameAdd);
    addASongElement.appendChild(addSongButton);

    addSongButton.addEventListener('click', () => {
        
        let jsonObject = {
            "songTitle" : document.querySelector('.song-input-name').value
            // "album name" : document.querySelector('.album-input-name').value,
            // "artist name" : document.querySelector('.artist-input-name').value
        };
        addNewSong(jsonObject, id);
    });

    return addASongElement;
}