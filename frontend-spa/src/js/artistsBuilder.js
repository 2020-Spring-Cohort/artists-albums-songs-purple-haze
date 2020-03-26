export {displayAllArtists}
import {renderAllArtists,
    renderSingleArtist

} from './app.js';


const createArtistsElements = (jsonData) => { 
    console.log(jsonData);
    jsonData.forEach((artist) => { 
const anchor = document.querySelector('.anchor');
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

singleArtist.style.cursor = 'pointer';
singleArtist.addEventListener('click', ()=>{
    console.log(artist.id);
    renderSingleArtist(artist.id);
})

anchor.appendChild(singleArtist);
singleArtist.appendChild(artistPic);
singleArtist.appendChild(artistName);
singleArtist.appendChild(artistLabel);


})

};


const displayAllArtists = () => {
    fetch(`http://localhost:8080/artists/`)
        .then(response => response.json())
        // .then(artistJson => console.log(artistJson))
        .then(artistInfo => createArtistsElements(artistInfo))
}



