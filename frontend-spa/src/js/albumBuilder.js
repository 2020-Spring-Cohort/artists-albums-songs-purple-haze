export {
    displaySingleAlbum
}

const createSingleAlbumElements = (album) => {
    // console.log(album);
    const anchor = document.querySelector('.anchor');
    anchor.classList.add('songs-section');
    const albumList = document.createElement('DIV');
    albumList.classList.add('song-list');

    const singleAlbum = document.createElement('DIV');
    singleAlbum.classList.add('album-detail-pic');

    const albumPic = document.createElement('IMG');
    const albumName = document.createElement('H3');
    const artistName = document.createElement('H3');
    albumPic.src = `http://placekitten.com/250/250`;
    albumPic.classList.add('album-picture');

    albumName.innerHTML = album.albumTitle;
    artistName.innerHTML = album.name;

    singleAlbum.appendChild(albumPic);
    singleAlbum.appendChild(albumName);

    anchor.appendChild(singleAlbum);


        const singleSongHeader = document.createElement('DIV')
        singleSongHeader.classList.add('single-song-title');

        const singleSongTitleName = document.createElement('h3')
        const singleSongTitleArtist = document.createElement('h3')

        singleSongTitleName.innerHTML = "Song Name";
        singleSongTitleArtist.innerHTML = "Artist Name";

        singleSongHeader.appendChild(singleSongTitleName);
        singleSongHeader.appendChild(singleSongTitleArtist);

        albumList.append(singleSongHeader);

    album.songs.forEach(song => {

        const singleSongBox = document.createElement('DIV')
        singleSongBox.classList.add('single-song-detail');


        const songTitle = document.createElement('p');
        songTitle.classList.add('song-title');
        songTitle.innerHTML = song.songTitle;

        const albumName = document.createElement('p');
        albumName.classList.add('album-name');
        albumName.innerHTML = song.songTitle;
        // anchor.appendChild(songSection);
        // anchor.appendChild(albumList);
        singleSongBox.appendChild(songTitle);
        singleSongBox.appendChild(albumName);
        // singleSongBox.appendChild(artistName);
        // singleSongBox.appendChild(duration);
        albumList.appendChild(singleSongBox);

    });



    anchor.appendChild(albumList);
}

const displaySingleAlbum = (album) => {
    fetch('http://localhost:8080/albums/' + album)
        .then(response => response.json())
        .then(singleAlbumInfo => createSingleAlbumElements(singleAlbumInfo))
};