import {
    displayAllArtists
} from './artistsBuilder.js';
import {
    displayAllAlbums
} from './albumsBuilder.js';
import {
    displaySingleArtist
}from './singleArtistBuilder.js';
import {
    displayAddNewArtist
} from './addArtist.js';
import { 
    addArtistToDataBase
}from './postRequests.js';

import {displaySingleAlbum} from './albumBuilder.js';

export {
    renderAllArtists,
    renderAllAlbums,
    renderSingleArtist,
    renderSingleAlbum,
    displaySingleAlbum,
    addNewArtist,
    clearView
}

const anchor = document.querySelector('.anchor');

const renderAllArtists = () => {
    clearView();
    displayAllArtists(anchor);


}

const addNewArtist = (jsonObject) => {
    clearView();
    // console.log(jsonObject);
    addArtistToDataBase(jsonObject);
    // renderAllArtists();
}

const renderSingleArtist = (id) => {
    clearView();
    displaySingleArtist(id, anchor);
}

const renderSingleAlbum = (album, ) => {
    clearView();
    displaySingleAlbum(album);

}

const renderAllAlbums = () => {
    clearView();
    displayAllAlbums();
}
const clearView = () => {
    while (anchor.firstChild) {
        // anchor.classList.remove = ('main-section');
        anchor.removeChild(anchor.firstChild);
    }
}



renderAllArtists();

const allArtistsNav = document.querySelector('.all-artists-menu');
allArtistsNav.addEventListener('click', renderAllArtists);

const allAlbumsNav = document.querySelector('.all-albums-menu');
allAlbumsNav.addEventListener('click', renderAllAlbums);