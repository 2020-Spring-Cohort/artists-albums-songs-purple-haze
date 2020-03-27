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
 document.querySelector('.main-header').innerText = artist.name;
    const sectionElement = document.createElement('SECTION');
    sectionElement.classList.add('artist-detail');

    const artistInfo = document.createElement('DIV');
    artistInfo.classList.add('artist-detail-info');

    const artistData = document.createElement('DIV');
    artistData.classList.add('artist-detail-data');

    const artistPicture = new Image();
    artistPicture.src = 'http://placekitten.com/250/250';

    const artistName = document.createElement("H3");
    artistName.classList.add('artist-name');
    artistName.innerHTML = artist.name;
    artistName.style = ('margin: 0');

    const artistGenre = document.createElement('P');
    artistGenre.classList.add('artist-genre');
    artistGenre.innerHTML = (artist.recordLabel === null ? "Unsigned" : artist.recordLabel);
     artistGenre.style = ('margin: 0 !important');

    const artistbirthDate = document.createElement('P');
    artistbirthDate.classList.add('artist-birthDate');
    artistbirthDate.innerHTML = 'Created: ' + (artist.birthDate =='null' ? artist.birthDate : 'Some Time In the 70s');

    const artistLabel = document.createElement('P');
    artistLabel.classList.add('artist-label');
    artistLabel.innerHTML = 'Label: ' + (artist.recordLabel =='null' ? artist.recordLabel : 'Unsigned');

    const artistHomeTown = document.createElement('P');
    artistHomeTown.classList.add('artist-hometown');
    artistHomeTown.innerHTML = "Hometown: " + (artist.hometown=='null' ? artist.hometown : 'Not Known');

    const thumbsSection = document.createElement('div');
    thumbsSection.classList.add('artist-thumbs-section');
    thumbsSection.innerHTML =  ' <div class = "thumb thumbsup" <span class = "num-thumbs-up" > 1 </span> Thumbs Up </div> <div class = "thumb thumbsdown" > <span class = "num-thumbs-down" > 2 </span>Thumb Down'


    artistData.appendChild(artistName);

    artistData.appendChild(artistbirthDate);
    artistData.appendChild(artistLabel);
    artistData.appendChild(artistHomeTown);

    artistInfo.appendChild(artistPicture);
    artistInfo.appendChild(artistData);
    artistInfo.appendChild(thumbsSection);

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

    sectionElement.appendChild(artistInfo);
    sectionElement.appendChild(albumList);
    return sectionElement;
}

const displaySingleArtist = (id, anchorElement) => {
    fetch(`http://localhost:8080/artists/${id}`)
        .then(response => response.json())
        .then(singleArtistInfo => anchorElement
            .append(createSingleArtistElements(singleArtistInfo)))
       
};