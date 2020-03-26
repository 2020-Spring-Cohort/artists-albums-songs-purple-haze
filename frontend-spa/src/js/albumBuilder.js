export {displaySingleAlbum}

const createSingleAlbumElements = (album)=> {
    console.log(album);
    const albumList = document.createElement('DIV');
    albumList.classList.add('song-list');

    album.songs.forEach(song => {
    console.log(song.songTitle)


    const anchor = document.querySelector('.anchor');
    const songSection = document.createElement('DIV');

    const songTitle = document.createElement('H3');
    songTitle.innerHTML = song.songTitle;

    anchor.appendChild(songSection);
    anchor.appendChild(albumList);
    songSection.appendChild(songTitle);
     

});

    const singleAlbum = document.createElement('DIV');
    singleAlbum.classList.add('single-album');
    const albumPic = document.createElement('IMG');
    const albumName = document.createElement('H3');
    const artist = document.createElement('H3');
    albumPic.src = `http://placekitten.com/250/250`;
    albumPic.classList.add('album-picture');

    
    singleAlbum.appendChild(albumPic);
    albumName.innerHTML = album.albumTitle;
    artist.innerHTML = album.name;
    singleAlbum.appendChild(albumName);
    albumList.appendChild(singleAlbum);


}

const displaySingleAlbum = (id,albumId) => {
    fetch(`http://localhost:8080/artists/${id}/${albumId}`)
            .then(response => response.json())
            .then(singleAlbumInfo => createSingleAlbumElements(singleAlbumInfo))
};



    