import {
    addNewArtist, clearView
} from './app.js';

export {
    displayAddNewArtist
}
const displayAddNewArtist = () => {

    // const anchor = document.querySelector('.anchor');

    const addAnArtistElement = document.createElement('DIV');
    addAnArtistElement.classList.add('single-artist');

    const artistAddTitle = document.createElement("H3");
    artistAddTitle.classList.add('artist-name');
    artistAddTitle.innerHTML = 'Add An Artist';

    const artistNameAdd = document.createElement('input');
    artistNameAdd.classList.add('artist-input-name');
    artistNameAdd.placeholder = "Artists Name";

    const artistURL = document.createElement('input');
    artistURL.placeholder = "Artists URL";


    const artistGenreToAdd = document.createElement('input');
    artistGenreToAdd.classList.add('artist-input-genre');
    artistGenreToAdd.placeholder = "Artists Genre (Optional)";


    const addArtistButton = document.createElement('button');
    addArtistButton.classList.add('submit');
    addArtistButton.innerHTML = "Submit";
    addArtistButton.style.cursor = 'pointer';


    addAnArtistElement.appendChild(artistAddTitle);
    addAnArtistElement.appendChild(artistNameAdd);
    addAnArtistElement.appendChild(artistGenreToAdd);
    addAnArtistElement.appendChild(artistURL);
    addAnArtistElement.appendChild(addArtistButton);

    // let formDataObj = {};
    // addAnArtistElement.forEach((value, key) => {formDataObj[key] = value});

    addArtistButton.addEventListener('click', () => {
        // getJsonData(addAnArtistElement);
        let jsonObject = {
            "name" : document.querySelector('.artist-input-name').value,
            "recordLabel" : document.querySelector('.artist-input-genre').value
            // "url" : document.querySelector('.artist-input-name').value
        };
        addNewArtist(jsonObject);
        clearView();
    });

    return addAnArtistElement;

}