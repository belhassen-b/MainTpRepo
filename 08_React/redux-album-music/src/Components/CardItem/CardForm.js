import { useRef } from "react"
import { useSelector } from "react-redux"

const CardAlbumForm = (props) => {
    const mode = props.mode
    const album = useSelector(state => state.albums.albums).find(r => r.id === props.albumId)

    const titleRef = useRef()
    const artistRef = useRef()
    const releaseDateRef = useRef()
    const rateRef = useRef()
    const priceRef = useRef()
    const coverRef = useRef()




    const submitFormHandler = (event) => {
        event.preventDefault()

        if (mode === 'delete') {
            props.onDelete(album.id)
        } else {
            const title = titleRef.current.value
            const artist = artistRef.current.value
            const releaseDate = releaseDateRef.current.value
            const rate = rateRef.current.value
            const price = priceRef.current.value
            const cover = coverRef.current.value

            const tmpArray = []

            const albumValues = {
                title,
                artist,
                releaseDate,
                rate,
                price,
                cover
            }

            console.log(albumValues);

            titleRef.current.value = ""
            artistRef.current.value = ""
            releaseDateRef.current.value = ""
            rateRef.current.value = ""
            priceRef.current.value = ""
            coverRef.current.value = ""

           if (mode === 'add') {
                props.onAdd(albumValues)
            } else if (mode === 'edit') {
                props.onEdit({...albumValues, id: album.id})
            }
        }
    }

    return (
        <form onSubmit={submitFormHandler}>
            <div className="text-end">
                <button className={`btn btn-${mode === 'delete'? 'danger' : mode === 'edit' ? 'warning' : 'success'}`}>
                    <i className={`bi bi-${mode === 'delete' ? 'trash' : mode === 'edit' ? 'pencil-square' : 'plus-circle'}`}></i> {mode === 'delete' ? 'Confirmer' : mode === 'edit' ? 'Editer' : 'Envoyer'}
                </button>
            </div>
            <div className="mb-3">
                <label htmlFor="title" className="form-label">Titre: </label>
                <input type="text" ref={titleRef} required={mode !== 'delete'} disabled={mode === 'delete'} defaultValue={album?.title} className="form-control" />
            </div>
            <div className="mb-3">
                <label htmlFor="artist" className="form-label">Artist: </label>
                <input type="text" ref={artistRef} required={mode !== 'delete'} disabled={mode === 'delete'} defaultValue={album?.artist} className="form-control" />
            </div>

            <div className="mb-3">
                <label htmlFor="releaseDate" className="form-label">Release Date: </label>
                <input type="date²" ref={releaseDateRef} required={mode !== 'delete'} disabled={mode === 'delete'} defaultValue={album?.releaseDate} className="form-control" />
            </div>
            <div className="mb-3">
                <label htmlFor="rate" className="form-label">Rate: </label>
                <textarea ref={rateRef} required={mode !== 'delete'} disabled={mode === 'delete'} defaultValue={album?.rate} className="form-control" cols={30} rows={10} style={{resize: "none"}}></textarea>
            </div>
            <div className="mb-3">
                <label htmlFor="price" className="form-label">price: </label>
                <textarea ref={priceRef} required={mode !== 'delete'} disabled={mode === 'delete'} defaultValue={album?.price} className="form-control" cols={30} rows={10} style={{resize: "none"}}></textarea>
            </div>
            <div className="mb-3">
                <label htmlFor="cover" className="form-label">Cover Url: </label>
                <input type="text" ref={coverRef} required={mode !== 'delete'} disabled={mode === 'delete'} defaultValue={album?.cover} className="form-control" />
            </div>
            <div className="text-end">
                <button className={`btn btn-${mode === 'delete'? 'danger' : mode === 'edit' ? 'warning' : 'success'}`}>
                    <i className={`bi bi-${mode === 'delete' ? 'trash' : mode === 'edit' ? 'pencil-square' : 'plus-circle'}`}></i> {mode === 'delete' ? 'Confirmer' : mode === 'edit' ? 'Editer' : 'Envoyer'}
                </button>
            </div>
        </form>
    )
}

export default CardAlbumForm