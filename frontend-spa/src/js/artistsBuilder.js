export {
    displayAllArtists
}
import {
    renderAllArtists,
    renderSingleArtist,
    addNewArtist

} from './app.js';
import { displayAddNewArtist } from './addArtist.js';


const createArtistsElements = (jsonData) => {
    // console.log(jsonData);
    const artistsSection = document.createElement('div');
    artistsSection.classList.add('main-section');
    jsonData.forEach((artist) => {

        const singleArtist = document.createElement('DIV');
        singleArtist.classList.add('single-artist');

        const artistPic = document.createElement('IMG');
        artistPic.src = `http://placekitten.com/250/250`;
        artistPic.classList.add('artist-picture');

        const artistName = document.createElement("H3");
        artistName.classList.add('artist-name');
        artistName.innerHTML = artist.name;
        // artistName.addEventListener('onclick', displaysingleartist(artist.id))

        const artistLabel = document.createElement('H4');
        artistLabel.classList.add('artist-label');
        artistLabel.innerHTML = (artist.label == 'undefined' ? artist.label : 'Unsigned Label');

        //clickEvent
        singleArtist.style.cursor = 'pointer';
        singleArtist.addEventListener('click', () => {
            console.log(artist.id);
            renderSingleArtist(artist.id);
        })

        singleArtist.appendChild(artistPic);
        singleArtist.appendChild(artistName);
        singleArtist.appendChild(artistLabel);
    artistsSection.appendChild(singleArtist);

    })
artistsSection.appendChild(displayAddNewArtist());
return artistsSection;
};


const displayAllArtists = (anchorElement) => {
    fetch(`http://localhost:8080/artists/`)
        .then(response => response.json())
        // .then(artistJson => console.log(artistJson))
        .then(artistInfo =>  anchorElement
            .append(createArtistsElements(artistInfo)));

        
}