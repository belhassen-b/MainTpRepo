import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { BASE_DB_URL } from "../../firebaseConfig";

export const fetchAlbums = createAsyncThunk(
    "albums/fetchAlbums",
    async () => {
        const response = await fetch(`${BASE_DB_URL}albums.json`)
        if (!response.ok) {
            throw new Error("Erreur lors de la récupération des Albums !")
        }

        const data = await response.json()

        const tmpArray = []

        for (const key in data) {
            tmpArray.push({id: key, ...data[key]})
        }

        return tmpArray
    }
)

export const addAlbum = createAsyncThunk(
    "albums/addAlbum",
    async (albumValues, {getState}) => {
        const user = getState().auth.user
        if (user) {
            const token = user.idToken
            if (token) {
                const response = await fetch(`${BASE_DB_URL}albums.json?auth=${token}`, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(albumValues)
                })

                if (!response.ok) {
                    throw new Error("Il y a eu une erreur lors de la requête POST d'un album !")
                }

                const data = await response.json()

                return {id: data.name, ...albumValues}
            }
        }
    }
)

export const editAlbum = createAsyncThunk(
    "albums/editAlbum",
    async ({id, ...albumValues}, {getState}) => {
        const user = getState().auth.user
        if (user) {
            const token = user.idToken
            if (token) {
                const response = await fetch(`${BASE_DB_URL}albums/${id}.json?auth=${token}`, {
                    method: "PATCH",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(albumValues)
                })

                if (!response.ok) {
                    throw new Error("Il y a eu une erreur lors de la requête PATCH d'un Album !")
                }

                const data = await response.json()

                return {id, ...data}
            }
        }
    }
)

export const deleteAlbum = createAsyncThunk(
    "albums/deleteAlbum",
    async (albumId, {getState}) => {
        const user = getState().auth.user
        if (user) {
            const token = user.idToken
            if (token) {
                const response = await fetch(`${BASE_DB_URL}albums/${albumId}.json?auth=${token}`, {
                    method: "DELETE"
                })

                if (!response.ok) {
                    throw new Error("Il y a eu une erreur lors de la requête DELETE d'un Album !")
                }

                return albumId
            }
        }
    }
)

const albumsSlice = createSlice({
    name: "album",
    initialState: {
        albums: [

        ],
        isLoading: false,
        error: null,
    },
    reducers: {
        addAlbumAction(state, action) {
            state.albums.push(action.payload)
        },
        setAlbumAction(state, action) {
            state.albums = action.payload
        },
        editAlbumAction(state, action) {
            const {id} = action.payload
            const albumFound = state.albums.find(r => r.id === id)
            if (albumFound) {
                state.albums = [...state.albums.filter(r => r.id !== id), action.payload]
            }
        },
        deleteAlbumAction(state, action) {
            const id = action.payload
            const albumFound = state.albums.find(r => r.id === id)
            if (albumFound) {
                state.albums = state.albums.filter(r => r.id !== id)
            }
        },
    },
    extraReducers: (builder) => {
        builder.addCase(fetchAlbums.pending, (state) => {
            state.isLoading = true
            state.error = null
            state.albums = []
        })

        builder.addCase(fetchAlbums.fulfilled, (state, action) => {
            state.isLoading = false
            state.albums = action.payload
        })

        builder.addCase(fetchAlbums.rejected, (state, action) => {
            state.isLoading = false
            state.error = action.payload
        })

        builder.addCase(addAlbum.fulfilled, (state, action) => {
            state.albums.push(action.payload)
        })

        builder.addCase(deleteAlbum.fulfilled, (state, action) => {
            state.albums = state.albums.filter(r => r.id !== action.payload)
        })

        builder.addCase(editAlbum.fulfilled, (state, action) => {
            const {id} = action.payload
            const albumFound = state.albums.find(r => r.id === id)
            if (albumFound) {
                state.albums = [...state.albums.filter(r => r.id !== id), action.payload]
            }
        })
    }
})

export const { addAlbumAction, setAlbumAction, editAlbumAction, deleteAlbumAction } = albumsSlice.actions

export default albumsSlice.reducer