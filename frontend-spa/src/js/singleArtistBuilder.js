
const createSingleArtistElements = (artist) => {
    console.log(artist);


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

const fetchArtist = () => {
    fetch(`http://localhost:8080/artists/1`)
            .then(response => response.json())
            .then(singleArtistInfo => createSingleArtistElements(singleArtistInfo))
};

fetchArtist();