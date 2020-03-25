import {displayAllArtists} from './artistsBuilder.js';
import {displayAllAlbums} from './albumsBuilder.js';
export {renderAllArtists}
export {renderAllAlbums}


const anchor = document.querySelector('.anchor');

const clearView = () => {
    while (anchor.firstChild) {
        anchor.class.remove = ('main-section');
        anchor.removeChild(anchor.firstChild);
    }
}

const renderAllArtists = () => {
    clearView();
    anchor.classList.add('main-section');
    displayAllArtists();
}
 const renderAllAlbums = () => {
    clearView();
    anchor.classList.add('main-section');
    displayAllAlbums();
}




// fetchArtists();

const allArtistsNav = document.querySelector('.all-artists-menu');
allArtistsNav.addEventListener('click', renderAllArtists);

const allAlbumsNav = document.querySelector('.all-albums-menu');
allAlbumsNav.addEventListener('click', renderAllAlbums);
