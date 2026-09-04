import { useMemo, useState } from 'react'
import './App.css'

function App() {
  const [letterOpen, setLetterOpen] = useState(false)
  const [showImage, setShowImage] = useState(true)
  const [imageIndex, setImageIndex] = useState(0)

  const imageCandidates = ['/pp.jpeg', '/pp.jpg', '/pp.png', '/pp.webp', '/shikha.jpg']
  const currentImage = imageCandidates[imageIndex]

  const petals = useMemo(
    () =>
      Array.from({ length: 18 }, (_, index) => ({
        id: index,
        left: `${Math.random() * 100}%`,
        delay: `${Math.random() * 6}s`,
        duration: `${8 + Math.random() * 8}s`,
      })),
    [],
  )

  return (
    <main className="proposal-page">
      <div className="petals" aria-hidden="true">
        {petals.map((petal) => (
          <span
            key={petal.id}
            className="petal"
            style={{
              left: petal.left,
              animationDelay: petal.delay,
              animationDuration: petal.duration,
            }}
          />
        ))}
      </div>

      <section className="card">
        <p className="intro">For Shikha</p>
        <h1>
          A Rose, A Promise,
          <br />
          A Forever
        </h1>

        <p className="lead">
          Shikha, every day with you feels like a soft sunrise and every night feels
          like a sky full of wishes.
        </p>

        <div className="rose-row" aria-label="decorative roses">
          <span>🌹</span>
          <span>🌹</span>
          <span>🌹</span>
        </div>

        {showImage ? (
          <figure className="photo-frame">
            <img
              src={currentImage}
              alt="Shikha"
              onError={() => {
                if (imageIndex < imageCandidates.length - 1) {
                  setImageIndex((index) => index + 1)
                } else {
                  setShowImage(false)
                }
              }}
            />
          </figure>
        ) : (
          <p className="photo-note">Add public/pp.jpeg, public/pp.jpg, or public/shikha.jpg to show her photo.</p>
        )}

        <button
          type="button"
          className="open-letter"
          onClick={() => setLetterOpen((open) => !open)}
        >
          {letterOpen ? 'Close my heart letter' : 'Open my heart letter'}
        </button>

        <article className={`letter ${letterOpen ? 'open' : ''}`}>
          <p>
            My dearest Shikha,
            <br />
            you are the calm in my chaos, the laugh in my ordinary, and the dream I
            never want to wake up from.
          </p>
          <p>
            Will you let me hold your hand through every season, every sunrise, and
            every small beautiful moment of life?
          </p>
          <h2>Will you be mine, forever? 🌹</h2>
        </article>
      </section>
    </main>
  )
}

export default App
