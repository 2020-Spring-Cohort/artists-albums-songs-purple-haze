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


export {
    renderAllArtists,
    renderAllAlbums,
    renderSingleArtist,
    addNewArtist
}

const anchor = document.querySelector('.anchor');


const renderAllArtists = () => {
    clearView();
    anchor.classList.add('main-section');
    displayAllArtists();
    anchor.append(displayAddNewArtist());
    // const submitButton = form.querySelector('.submit');
    // submitButton.addEventListener('click', addNewArtist);
}

const addNewArtist = (jsonObject) => {
    clearView();
    // console.log(jsonObject);
    addArtistToDataBase(jsonObject);

    renderAllArtists();
}

const renderSingleArtist = (id) => {
    clearView();
    displaySingleArtist(id);
}
const renderAllAlbums = () => {
    clearView();
    anchor.classList.add('main-section');
    displayAllAlbums();
}
const clearView = () => {
    while (anchor.firstChild) {
        anchor.classList.remove = ('main-section');
        anchor.removeChild(anchor.firstChild);
    }
}



//fetchArtists();

const allArtistsNav = document.querySelector('.all-artists-menu');
allArtistsNav.addEventListener('click', renderAllArtists);

const allAlbumsNav = document.querySelector('.all-albums-menu');
allAlbumsNav.addEventListener('click', renderAllAlbums);