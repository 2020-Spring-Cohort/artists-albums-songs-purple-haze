import {
    displayAllArtists
} from './artistsBuilder.js';
import {
    displayAllAlbums
} from './albumsBuilder.js';
import {
    displaySingleArtist
}from './singleArtistBuilder.js';

import {displaySingleAlbum} from './albumBuilder.js';

export {
    renderAllArtists,
    renderAllAlbums,
    renderSingleArtist,
    renderSingleAlbum
}



const anchor = document.querySelector('.anchor');

const clearView = () => {
    while (anchor.firstChild) {
        anchor.classList.remove = ('main-section');
        anchor.removeChild(anchor.firstChild);
    }
}

const renderAllArtists = () => {
    clearView();
    anchor.classList.add('main-section');
    displayAllArtists();
}

const renderSingleArtist = (id) => {
    clearView();
    displaySingleArtist(id);


}
const renderSingleAlbum = (id) => {
    clearView();
    displaySingleAlbum(id);
}

const renderAllAlbums = () => {
    clearView();
    anchor.classList.add('main-section');
    displayAllAlbums();
}




//fetchArtists();

const allArtistsNav = document.querySelector('.all-artists-menu');
allArtistsNav.addEventListener('click', renderAllArtists);

const allAlbumsNav = document.querySelector('.all-albums-menu');
allAlbumsNav.addEventListener('click', renderAllAlbums);