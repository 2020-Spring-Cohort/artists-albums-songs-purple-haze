export {
    displaySingleArtist
}

const createSingleArtistElements = (artist) => {
    // console.log(artist);
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

singleAlbum.appendChild(albumPic);
albumName.innerHTML = album.albumTitle;
artistName.innerHTML = artist.name;
singleAlbum.appendChild(albumName);
singleAlbum.appendChild(artistName);
albumList.appendChild(singleAlbum);


});

const anchor = document.querySelector('.anchor');
const artistSection = document.createElement('DIV');

const artistName = document.createElement("H3");
artistName.classList.add('artist-name');
artistName.innerHTML = artist.name;

const artistGenre = document.createElement('P');
artistGenre.classList.add('artist-genre');
artistGenre.innerHTML = (artist.genre == 'undefined' ? artist.genre : 'No Genre');

const artistbirthDate = document.createElement('P');
artistbirthDate.classList.add('artist-birthDate');
artistbirthDate.innerHTML = artist.birthDate;

const artistLabel = document.createElement('P');
artistLabel.classList.add('artist-label');
artistLabel.innerHTML = artist.recordlabel;

const artistHomeTown = document.createElement('P');
artistHomeTown.classList.add('artist-hometown');
artistHomeTown.innerHTML = artist.hometown;

anchor.appendChild(artistSection);
anchor.appendChild(albumList);
//name
    artistSection.appendChild(artistName);
//genre
    artistSection.appendChild(artistGenre);
//age
    artistSection.appendChild(artistbirthDate);
//label
    artistSection.appendChild(artistLabel);
// hometown
    artistSection.appendChild(artistHomeTown);

}

const displaySingleArtist = (id) => {
    fetch(`http://localhost:8080/artists/${id}`)
            .then(response => response.json())
            .then(singleArtistInfo => createSingleArtistElements(singleArtistInfo))
};

