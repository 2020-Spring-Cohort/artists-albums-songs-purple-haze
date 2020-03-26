import {
    displaySingleAlbum
} from "./albumBuilder.js";
import {
    renderSingleAlbum
} from "./app.js";

export {
    displaySingleArtist
}

const createSingleArtistElements = (artist) => {
    // console.log(artist);


    const sectionElement = document.createElement('SECTION');
    sectionElement.classList.add('artist-detail');
const artistSection = document.createElement('DIV');

const artistName = document.createElement("H3");
artistName.classList.add('artist-name');
artistName.innerHTML = artist.name;

const artistGenre = document.createElement('P');
artistGenre.classList.add('artist-genre');
artistGenre.innerHTML = (artist.recordLabel === null ? "Unsigned" : artist.recordLabel);

const artistbirthDate = document.createElement('P');
artistbirthDate.classList.add('artist-birthDate');
artistbirthDate.innerHTML = artist.birthDate;

const artistLabel = document.createElement('P');
artistLabel.classList.add('artist-label');
artistLabel.innerHTML = artist.recordlabel;

const artistHomeTown = document.createElement('P');
artistHomeTown.classList.add('artist-hometown');
artistHomeTown.innerHTML = artist.hometown;

artistSection.appendChild(artistName);
artistSection.appendChild(artistGenre);
artistSection.appendChild(artistbirthDate);
artistSection.appendChild(artistLabel);
artistSection.appendChild(artistHomeTown);

sectionElement.appendChild(artistSection);

    const albumList = document.createElement("div");
    albumList.classList.add('album-list');

    artist.albums.forEach(album => {
        // console.log(album.albumTitle)

        const singleAlbum = document.createElement("DIV");
        singleAlbum.classList.add('single-album');
        const artistName = document.createElement('p')
        const albumName = document.createElement('h3');
        const albumPic = document.createElement('IMG');
        albumPic.src = `http://placekitten.com/250/250`;
        albumPic.classList.add('album-picture');


        albumName.innerHTML = album.albumTitle;
        artistName.innerHTML = artist.name;

        singleAlbum.appendChild(albumPic);
        singleAlbum.appendChild(albumName);
        singleAlbum.appendChild(artistName);
        albumList.appendChild(singleAlbum);

        singleAlbum.addEventListener('click', () => {
            renderSingleAlbum(album.id);
        })

    });

sectionElement.appendChild(artistSection);
sectionElement.appendChild(albumList);
return sectionElement;
}

const displaySingleArtist = (id, anchorElement) => {
    fetch(`http://localhost:8080/artists/${id}`)
        .then(response => response.json())
        .then(singleArtistInfo => anchorElement
            .append(createSingleArtistElements(singleArtistInfo)))
};