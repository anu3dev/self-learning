/**
 * React code to be accessible and keyboard-friendly then have to follow WCAG and WAI-ARIA guidelines.
 * 
 * 
 * 
 * Use Semantic HTML First-of-all- 
 * prefer using semantic HTML elements (like <button>, <a>, <form>, etc.) over generic elements 
 * (like <div> or <span>) for interactive content. Semantic elements come with built-in accessibility 
 * features and are recognized by assistive technologies.
 * 
 * Example:
 * <div onClick={handleClick}>Submit</div> // Bad
 * <button onClick={handleClick}>Submit</button> // Good
 * 
 * 
 * 
 * Ensure Tab Navigation Works-
 * Any interactive element (like buttons, inputs, links) gets tabIndex automatically.
 * For custom interactive elements (like div or span), manually add: tabIndex={0} to make them focusable.
 * 
 * Example:
 * <div role="button" tabIndex={0} onClick={handleClick}>Submit</div> // Good
 * 
 * tabIndex={0} makes the element focusable and part of the natural tab order.
 * tabIndex={-1} makes the element focusable but removes it from the tab order. e.g. ref.current.focus()
 * tabIndex={1} or greater is generally discouraged as it creates a custom tab order that can confuse users.
 * 
 * 
 * 
 * Provide Accessible Labels-
 * Ensure all interactive elements have clear and descriptive labels.
 * Use aria-label, aria-labelledby or aria-describedby for elements that do not have visible text.
 * 
 * Example:
 * <input type="search" aria-label="Search site content" /> // Good
 * <input type="text" aria-describedby="searchHelp" /> // Good
 * <button aria-label="Close"> <svg>...</svg> </button> // Good
 * 
 * 
 * 
 * Use useRef for Programmatic Focus-
 * Use the useRef hook to manage focus on elements programmatically.
 * This is useful for modals, dialogs, or custom components that need to set focus when they appear.
 * 
 * Example:
 * const inputRef = useRef(null);
 * <button onClick={() => inputRef.current.focus()}>Focus Search</button>
 * <input ref={inputRef} type="text" placeholder="Search..." />
 * 
 * 
 * 
 * Manage Focus After Actions-
 * After actions like form submissions or modal openings, ensure focus is set to a logical element.
 * This helps users using screen readers or keyboard navigation to stay oriented.
 * 
 * Example:
 * useEffect(() => {
 *   if (isModalOpen) {
 *     inputRef.current.focus();
 *   }
 * }, [isModalOpen]);
 * 
 * 
 * 
 * Announce Updates to Screen Readers-
 * Use ARIA live regions to announce dynamic content updates to screen readers.
 * 
 * Example:
 * <div aria-live="polite"> {statusMessage} </div> // Goodyes
 */



/**
 * How to Test Accessibility
 * Keyboard only → Tab, Shift+Tab, Enter, Space, Escape.
 * Screen Reader → NVDA (Windows), VoiceOver (Mac).
 * Lighthouse audit → Chrome DevTools → Lighthouse → Accessibility score.
 */



/**
 * Accessible Button (Custom or Native)
 * Native <button> already supports Enter/Space keys & tab navigation.
 */
const AccessibleButton = () => {
  return (
    <button
      onClick={() => {}}
      aria-label="Submit Form"
      className=""
    >
      Submit
    </button>
  );
}



/**
 * Accessible Custom Clickable (When You Can’t Use <button>)
 * Now a div acts like a button for keyboard users.
 */
function CustomClickable({ onClick, label }) {
  const handleKeyDown = (e) => {
    if (e.key === "Enter" || e.key === " ") {
      e.preventDefault(); // Prevent page scroll on space
      onClick();
    }
  };

  return (
    <div
      role="button"
      tabIndex={0}
      onClick={onClick}
      onKeyDown={handleKeyDown}
      aria-label={label}
      className=""
    >
      {label}
    </div>
  )
}



/**
 * Accessible Modal
 * Focus is set to modal and trapped until closed.
 */
function AccessibleModal({ isOpen, onClose, children }) {
  const modalRef = useRef(null);

  // Trap focus inside modal
  useEffect(() => {
    if (isOpen) {
      modalRef.current.focus();
    }
  }, [isOpen]);

  if (!isOpen) return null;

  return (
    <div
      role="dialog"
      aria-modal="true"
      aria-label="Modal window"
      className="fixed inset-0 flex items-center justify-center bg-black/50"
      onClick={onClose}
    >
      <div
        ref={modalRef}
        tabIndex={-1}
        className="bg-white p-4 rounded shadow-lg"
        onClick={(e) => e.stopPropagation()}
      >
        {children}
        <button onClick={onClose} className="mt-4 p-2 bg-red-500 text-white rounded">
          Close
        </button>
      </div>
    </div>
  );
}



/**
 * Accessible Form Input
 * Uses label + htmlFor for screen readers.
 */
function AccessibleInput({ id, label, ...props }) {
  return (
    <div className="mb-3">
      <label htmlFor={id} className="block mb-1 font-medium">
        {label}
      </label>
      <input
        id={id}
        {...props}
        className=""
      />
    </div>
  );
}



/**
 * Live Region for Status Updates
 * Announces status changes (e.g., "Form submitted").
 */
function LiveRegion({ statusMessage }) {
  return (
    <div aria-live="polite" className="sr-only">
      {statusMessage}
    </div>
  );
}
