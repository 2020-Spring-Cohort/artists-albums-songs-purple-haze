export{displayAllAlbums
} 
import {
    renderSingleAlbum
}
from './app.js';



//get the json
const createAlbumsElements = (jsonData) => {
const albumList = document.createElement('DIV');
albumList.classList.add('album-list');

    jsonData.forEach(album => {

        const singleAlbum = document.createElement('DIV');
        singleAlbum.classList.add('single-album');


        const albumPic = document.createElement('IMG');
        albumPic.src = `https://store.acousticsounds.com/images/medium/ALEG_23981__65677__03082010031341-4566.jpg`;
        albumPic.classList.add('album-picture');
        
        const albumTitle = document.createElement('H3');
        albumTitle.innerHTML = (album.albumTitle === undefined ? 'No Title Yet' : album.albumTitle);

        const artist = document.createElement('P');
        artist.innerHTML = (album.artist === undefined ? 'No Artist Yet' : album.artist.name);
        
        singleAlbum.style.cursor = 'pointer';
        singleAlbum.addEventListener('click', () =>{
            // console.log(album.id);
            renderSingleAlbum(album.id);
        })

       
        singleAlbum.appendChild(albumPic);
        singleAlbum.appendChild(albumTitle);
        singleAlbum.appendChild(artist);
        albumList.appendChild(singleAlbum);

    });
return albumList;
};

const displayAllAlbums = () => {
    fetch(`http://localhost:8080/albums/`)
            .then(response => response.json())
            .then(albumInfo => document.querySelector('.anchor')
            .appendChild(createAlbumsElements(albumInfo)));
}



